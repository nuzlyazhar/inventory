/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import ejb.CustomerManagementEJB;
import ejb.ItemManagementEJB;
import ejb.UserManagementEJB;
import ejbimpl.CustomerManagementBean;
import ejbimpl.ItemManagementBean;
import ejbimpl.UserManagementBean;
import entity.Customer;
import entity.Item;
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
import javax.servlet.http.HttpSession;

/**
 *
 * @author nuzly
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    @EJB
    UserManagementEJB userManagementBean;
    
    @EJB
    CustomerManagementEJB customerManagementBean;
    
    @EJB
    ItemManagementEJB itemManagementBean;
  

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
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
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String userName = request.getParameter("loguname");
        String password = request.getParameter("logpassword");
        User u = userManagementBean.findByUsername(userName);
        List<Customer> customers = customerManagementBean.findAll();
        List<Item> alertItems = itemManagementBean.findAllItemsBelowReorderThreshold();
        if (null != u && null != password) {

            if (userManagementBean.validateUser(u, password)) {
                System.out.println("User Successfully Loggedin");

                HttpSession session = request.getSession(false);
                if (session != null) {
                    session.setAttribute("user", u);
                    session.setAttribute("logFname", u.getFirstName());
                    session.setAttribute("customers", customers);
                    session.setAttribute("alertItems", alertItems);
                }
                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                rd.include(request, response);

            } else {
                out.print("<p style=\"color:red\">Sorry user has not been approved.</p>");
                RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
                rd.include(request, response);
            }
        }else {
                out.print("<p style=\"color:red\">Sorry username or password incorrect.</p>");
                RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
                rd.include(request, response);
            }

    }
    


}
