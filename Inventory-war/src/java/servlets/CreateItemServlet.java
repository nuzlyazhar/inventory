/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import ejb.CategoryManagementBean;
import ejb.ItemManagementBean;
import ejb.SupplierManagementBean;
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
@WebServlet(name = "CreateItemServlet", urlPatterns = {"/CreateItemServlet"})
public class CreateItemServlet extends HttpServlet {

    @EJB
    SupplierManagementBean supplierManagementBean;

    @EJB
    CategoryManagementBean categoryManagementBean;
    
    @EJB
    ItemManagementBean itemManagementBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Supplier> suppliers = supplierManagementBean.findAllSuppliers();
        List<Category> categories = categoryManagementBean.findAll();

        request.setAttribute("suppliersList", suppliers);
        request.setAttribute("categoriesList", categories);

        RequestDispatcher rd = request.getRequestDispatcher("create_item.jsp");
        rd.include(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("iname");
        String desc = request.getParameter("idesc");
        String uprice = request.getParameter("uprice");
        String qperunit = request.getParameter("qperunit");
        String size = request.getParameter("size");
        String itemCat = request.getParameter("itemCat");
        String itemSup = request.getParameter("itemSup");
        String numunits = request.getParameter("numunits");
        String rothreshold = request.getParameter("rothreshold");
        
        Item item = new Item();
        item.setItemName(name);
        item.setItemDescription(desc);
        item.setUnitPrice(new BigDecimal(uprice));
        item.setQuanityPerUnit(Integer.parseInt(qperunit));
        item.setItemSize(size);
        item.setSupId(new Supplier(Integer.parseInt(itemSup)));
        item.setCatId(new Category(Integer.parseInt(itemCat)));
        item.setUnitsInStock(Integer.parseInt(numunits));
        item.setReorderThreshold(Integer.parseInt(rothreshold));
        
        itemManagementBean.createItem(item);
        List<Item> itemsList = itemManagementBean.findAllItems();
        request.setAttribute("itemsList", itemsList);
        RequestDispatcher rd = request.getRequestDispatcher("list_items.jsp");
        rd.include(request, response);

    }

}
