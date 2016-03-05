/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import ejb.SupplierManagementEJB;
import ejbimpl.SupplierManagementBean;
import entity.Category;
import entity.Supplier;
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
@WebServlet(name = "CreateSupplierServlet", urlPatterns = {"/CreateSupplierServlet"})
public class CreateSupplierServlet extends HttpServlet {

    @EJB
    SupplierManagementEJB supplierManagementBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Supplier> supplierList = supplierManagementBean.findAllSuppliers();
        request.setAttribute("supplierList", supplierList);
        RequestDispatcher rd = request.getRequestDispatcher("list_suppliers.jsp");
        rd.include(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String companyName = request.getParameter("cname");
        String contactFirstName = request.getParameter("cfname");
        String contactLastName = request.getParameter("clname");
        String companyAddress = request.getParameter("caddress");
        String companyPhone = request.getParameter("cphone");
        String companyFax = request.getParameter("cfax");
        String companyEmail = request.getParameter("cemail");
        String paymentMethod = request.getParameter("paym");

        Supplier supplier = new Supplier();
        supplier.setCompName(companyName);
        supplier.setContactFname(contactFirstName);
        supplier.setContactLname(contactLastName);
        supplier.setCompAddress(companyAddress);
        supplier.setCompPhone(companyPhone);
        supplier.setCompFax(companyFax);
        supplier.setCompEmail(companyEmail);
        supplier.setPaymentMethod(paymentMethod);

        supplierManagementBean.createSupplier(supplier);

        List<Supplier> supplierList = supplierManagementBean.findAllSuppliers();
        request.setAttribute("supplierList", supplierList);
        RequestDispatcher rd = request.getRequestDispatcher("list_suppliers.jsp");
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
