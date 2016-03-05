/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import ejb.ItemManagementBean;
import entity.Item;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "UpdateStocksServlet", urlPatterns = {"/UpdateStocksServlet"})
public class UpdateStocksServlet extends HttpServlet {

    @EJB
    ItemManagementBean itemManagementBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("siname");
        String unitsToAdd = request.getParameter("newstock");
        Item item = itemManagementBean.searchItemByName(name);
        int units = item.getUnitsInStock();
        int newUnits = Integer.parseInt(unitsToAdd);
        item.setUnitsInStock(units+newUnits);
        item = itemManagementBean.createItem(item);
         request.setAttribute("searchItem", item);
        RequestDispatcher rd = request.getRequestDispatcher("add_stock.jsp");
        rd.include(request, response);
    }

}
