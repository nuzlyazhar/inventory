/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import ejb.CustomerManagementEJB;
import entity.Customer;
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
@WebServlet(name = "EditCustomerServlet", urlPatterns = {"/EditCustomerServlet"})
public class EditCustomerServlet extends HttpServlet {

    @EJB
    CustomerManagementEJB customerManagementBean;


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
        String id = request.getParameter("editCust");
        Customer cu = customerManagementBean.findById(id);
         request.setAttribute("editCustomer", cu);
       
        RequestDispatcher rd = request.getRequestDispatcher("edit_customer.jsp");
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
         HttpSession session = request.getSession();
        String id = request.getParameter("cutomerToEdit");
        Customer cust = customerManagementBean.findById(id);
        String fName = request.getParameter("cufname");
        String lname = request.getParameter("culname");
        String address = request.getParameter("cuadd");
        String phone = request.getParameter("cuphone");
        String email = request.getParameter("cuemail");
        
        cust.setFirstName(fName);
        cust.setLastName(lname);
        cust.setAddress(address);
        cust.setPhoneNo(phone);
        cust.setEmail(email);
        
        customerManagementBean.createItem(cust);
        List<Customer> customerList = customerManagementBean.findAll();
        request.setAttribute("customerList", customerList);
        if(null != session){
        session.setAttribute("customers", customerList);
        }
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
