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
import java.io.PrintWriter;
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
@WebServlet(name = "EditCategoryServlet", urlPatterns = {"/EditCategoryServlet"})
public class EditCategoryServlet extends HttpServlet {

    @EJB
    CategoryManagementEJB categoryManagementBean;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String editCategory = request.getParameter("editCategory");
        Category cat =categoryManagementBean.findCategoryById(Integer.parseInt(editCategory));
         request.setAttribute("editCategory", cat);
        RequestDispatcher rd = request.getRequestDispatcher("edit_category.jsp");
        rd.include(request, response);
        
        
    }

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String cname = request.getParameter("cname");
        String cdesc = request.getParameter("cdesc");
        String id = request.getParameter("editCategoryId");
        Category cat = categoryManagementBean.findCategoryById(Integer.parseInt(id));
        cat.setCatName(cname);
        cat.setCatDescription(cdesc);
        categoryManagementBean.createCategory(cat);
        List<Category> categoryList = categoryManagementBean.findAll();
        request.setAttribute("categoryList", categoryList);
        RequestDispatcher rd = request.getRequestDispatcher("list_categories.jsp");
        rd.include(request, response);
        
        
       
       
    }

 

}
