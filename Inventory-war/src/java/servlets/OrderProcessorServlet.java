/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import ejb.CustomerManagementEJB;
import ejb.OrderProcessorEJB;
import ejbimpl.CustomerManagementBean;
import ejbimpl.OrderProcessorBean;
import entity.Customer;
import entity.Order;
import entity.OrderDetail;
import entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
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
@WebServlet(name = "OrderProcessorServlet", urlPatterns = {"/OrderProcessorServlet"})
public class OrderProcessorServlet extends HttpServlet {

    @EJB
    OrderProcessorEJB orderProcessorBean;

    @EJB
    CustomerManagementEJB customerManagementBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Order> orderHistory = orderProcessorBean.findAll("orderDate");
        request.setAttribute("orderHistory", orderHistory);
        RequestDispatcher rd = request.getRequestDispatcher("order_history.jsp");
        rd.include(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String orderItemId = request.getParameter("removeItem");
        String confirmOrder = request.getParameter("confirm_order");
        if (null != orderItemId) {
            HttpSession session = request.getSession();
            Order order = (Order) session.getAttribute("sessionOrder");
            Collection<OrderDetail> orderDetils = order.getOrderDetailCollection();
            Iterator<OrderDetail> it = orderDetils.iterator();
            while (it.hasNext()) {
                OrderDetail od = it.next();
                if (od.getItemId().getId().equals(Integer.parseInt(orderItemId))) {
                    it.remove();
                }
            }
            session.setAttribute("sessionOrder", order);
            RequestDispatcher rd = request.getRequestDispatcher("order_overview.jsp");
            rd.include(request, response);

        } else if (null != confirmOrder) {
            String customerId = request.getParameter("customerList");
            HttpSession session = request.getSession();
            Order order = (Order) session.getAttribute("sessionOrder");
            Customer cus = customerManagementBean.findById(getCustomerId(customerId));
            order.setCustomerId(cus);

            User user = (User) session.getAttribute("user");
            order.setStaffId(user);
            orderProcessorBean.processOrder(order);
            List<Order> orderHistory = orderProcessorBean.findAll("orderDate");
            request.setAttribute("orderHistory", orderHistory);
            RequestDispatcher rd = request.getRequestDispatcher("order_history.jsp");
            rd.include(request, response);

        }

    }

    private static String getCustomerId(String value) {
        String[] cus = value.split("-");
        return cus[0].trim();

    }

}
