/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import ejb.ItemManagementEJB;
import entity.Category;
import entity.Item;
import entity.Supplier;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author nuzly
 */
@WebServlet(name = "EditItemServlet", urlPatterns = {"/EditItemServlet"})
public class EditItemServlet extends HttpServlet {

    @EJB
    ItemManagementEJB itemManagementBean;

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("editItem");
        Item item = itemManagementBean.getItemById(id);

        request.setAttribute("editItem", item);
        RequestDispatcher rd = request.getRequestDispatcher("edit_item.jsp");
        rd.include(request, response);

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("editItemId");
        String name = request.getParameter("iname");
        String desc = request.getParameter("idesc");
        String uprice = request.getParameter("uprice");
        String qperunit = request.getParameter("qperunit");
        String rothreshold = request.getParameter("rothreshold");

        Item item = itemManagementBean.getItemById(id);
        item.setItemName(name);
        item.setItemDescription(desc);
        item.setUnitPrice(new BigDecimal(uprice));
        item.setQuanityPerUnit(Integer.parseInt(qperunit));

        item.setReorderThreshold(Integer.parseInt(rothreshold));

        itemManagementBean.createItem(item);
        List<Item> itemsList = itemManagementBean.findAllItems();
        request.setAttribute("itemsList", itemsList);
        RequestDispatcher rd = request.getRequestDispatcher("list_items.jsp");
        rd.include(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
