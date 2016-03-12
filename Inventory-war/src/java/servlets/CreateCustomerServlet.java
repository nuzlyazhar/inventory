/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import ejb.CustomerManagementEJB;
import ejbimpl.CustomerManagementBean;
import entity.Customer;
import entity.User;
import java.io.IOException;
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
@WebServlet(name = "CreateCustomerServlet", urlPatterns = {"/CreateCustomerServlet"})
public class CreateCustomerServlet extends HttpServlet {

    @EJB
    CustomerManagementEJB customerManagementBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          
        List<Customer> customerList = customerManagementBean.findAll();
        request.setAttribute("customerList", customerList);
        RequestDispatcher rd = request.getRequestDispatcher("list_customers.jsp");
        rd.include(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String fName = request.getParameter("cufname");
        String lname = request.getParameter("culname");
        String address = request.getParameter("cuadd");
        String phone = request.getParameter("cuphone");
        String email = request.getParameter("cuemail");

        Customer cust = new Customer();
        cust.setFirstName(fName);
        cust.setLastName(lname);
        cust.setAddress(address);
        cust.setPhoneNo(phone);
        cust.setEmail(email);
        if (null != session) {
            User u = (User) session.getAttribute("user");
            cust.setStaffId(u);
        }

        customerManagementBean.createItem(cust);
        List<Customer> customerList = customerManagementBean.findAll();
        request.setAttribute("customerList", customerList);
        session.setAttribute("customers", customerList);
        RequestDispatcher rd = request.getRequestDispatcher("list_customers.jsp");
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
