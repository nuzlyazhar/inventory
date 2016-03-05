/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import ejb.UserManagementBean;
import entity.User;
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
import utils.EmailUtils;

/**
 *
 * @author nuzly
 */
@WebServlet(name = "admin", urlPatterns = {"/admin"})
public class AdminApprovalServlet extends HttpServlet {

    @EJB
    UserManagementBean userManagementBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        System.out.println("servlets.AdminApprovalServlet.doGet()");
        List<User> users = userManagementBean.usersPendingApproval();
        request.setAttribute("usersList", users);
        RequestDispatcher rd = request.getRequestDispatcher("adminHome.jsp");
        rd.include(request, response);
        

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String updatedUserId = request.getParameter("updatedUser");
        System.out.println("updatedUserId :"+updatedUserId);
        User approvedUser = userManagementBean.approveUser(updatedUserId);
        userManagementBean.sendUserEmail(approvedUser);
        
         List<User> users = userManagementBean.usersPendingApproval();
        request.setAttribute("usersList", users);
        RequestDispatcher rd = request.getRequestDispatcher("adminHome.jsp");
        rd.include(request, response);

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
