/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import ejb.CategoryManagementEJB;
import ejbimpl.CategoryManagementBean;
import entity.Category;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.Constants;

/**
 *
 * @author nuzly
 */
@WebServlet(name = "AddCategoryServlet", urlPatterns = {"/AddCategoryServlet"})
public class AddCategoryServlet extends HttpServlet {

    @EJB
    CategoryManagementEJB categoryManagementBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Category> categoryList = categoryManagementBean.findAll();
        request.setAttribute("categoryList", categoryList);
        RequestDispatcher rd = request.getRequestDispatcher("list_categories.jsp");
        rd.include(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       
        String catName = request.getParameter("cname");
        String catDescription = request.getParameter("cdesc");

        Category category = new Category();
        category.setCatName(catName);
        category.setCatDescription(catDescription);
        categoryManagementBean.createCategory(category);
        
         List<Category> categoryList = categoryManagementBean.findAll();
        request.setAttribute("categoryList", categoryList);
        RequestDispatcher rd = request.getRequestDispatcher("list_categories.jsp");
        rd.include(request, response);
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
