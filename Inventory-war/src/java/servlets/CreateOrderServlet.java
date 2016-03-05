/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import ejb.CategoryManagementEJB;
import ejb.ItemManagementEJB;
import ejb.OrderProcessorEJB;
import ejb.SupplierManagementEJB;
import ejbimpl.CategoryManagementBean;
import ejbimpl.OrderProcessorBean;
import ejbimpl.ItemManagementBean;
import ejbimpl.SupplierManagementBean;
import entity.Category;
import entity.Item;
import entity.Supplier;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
@WebServlet(name = "CreateOrderServlet", urlPatterns = {"/CreateOrderServlet"})
public class CreateOrderServlet extends HttpServlet {

    @EJB
    OrderProcessorEJB createOrderBean;

    @EJB
    ItemManagementEJB itemManagementBean;

    @EJB
    CategoryManagementEJB categoryManagementBean;

    @EJB
    SupplierManagementEJB supplierManagementBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Category> categories = categoryManagementBean.findAll();
        List<Supplier> suppliers = supplierManagementBean.findAllSuppliers();
        List<Item> items = itemManagementBean.findAllItems();
        request.setAttribute("categories", categories);
        request.setAttribute("suppliers", suppliers);
        request.setAttribute("items", items);
        RequestDispatcher rd = request.getRequestDispatcher("create_order.jsp");
        rd.include(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String orderItem = request.getParameter("orderItem");

        System.out.println("submit button :" + orderItem);
        if (null == orderItem) {
            Map<String, String> queryParameters = new HashMap<String, String>();
            String itemName = request.getParameter("itemName");
            String catId = request.getParameter("categoryList");
            String supId = request.getParameter("suppliersList");
            System.out.println("servlets.CreateOrderServlet.doPost()");

            queryParameters.put("itemName", itemName);
            queryParameters.put("catId", catId);

            List<Item> items = itemManagementBean.searchItem(queryParameters);
            List<Category> categories = categoryManagementBean.findAll();
            List<Supplier> suppliers = supplierManagementBean.findAllSuppliers();

            request.setAttribute("categories", categories);
            request.setAttribute("suppliers", suppliers);
            request.setAttribute("items", items);
            RequestDispatcher rd = request.getRequestDispatcher("create_order.jsp");
            rd.include(request, response);
        } else {

            Item item = itemManagementBean.getItemById(orderItem);
            request.setAttribute("orderItem", item);
            RequestDispatcher rd = request.getRequestDispatcher("consume_item.jsp");
            rd.include(request, response);

        }
    }

}
