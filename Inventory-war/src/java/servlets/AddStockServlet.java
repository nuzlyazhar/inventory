/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import ejb.ItemManagementEJB;
import ejbimpl.ItemManagementBean;
import entity.Item;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "AddStockServlet", urlPatterns = {"/AddStockServlet"})
public class AddStockServlet extends HttpServlet {

    @EJB
    ItemManagementEJB itemManagementBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Item> stockItemList = itemManagementBean.findAllItems();
        request.setAttribute("stockItemList", stockItemList);
        RequestDispatcher rd = request.getRequestDispatcher("search_stock.jsp");
        rd.include(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String itemName = request.getParameter("items");
        Item item = itemManagementBean.searchItemByName(itemName);
        request.setAttribute("searchItem", item);
        RequestDispatcher rd = request.getRequestDispatcher("add_stock.jsp");
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
