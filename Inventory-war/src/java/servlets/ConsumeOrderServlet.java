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
import entity.Item;
import entity.Order;
import entity.OrderDetail;
import entity.User;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import utils.InventoryUtils;

/**
 *
 * @author nuzly
 */
@WebServlet(name = "ConsumeOrderServlet", urlPatterns = {"/ConsumeOrderServlet"})
public class ConsumeOrderServlet extends HttpServlet {

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

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String orderItem = request.getParameter("addToOrder");
        Item item = itemManagementBean.getItemById(orderItem);
        request.setAttribute("orderItem", item);

        String noOfUnits = request.getParameter("noOfUnits");
        HttpSession session = request.getSession(true);
        if (null == session.getAttribute("sessionOrder") && noOfUnits != null) {

            Order order = new Order();
            order.setOrderDate(Calendar.getInstance().getTime());
            order.setStaffId((User) session.getAttribute("user"));

            //create order detail
            OrderDetail od = new OrderDetail();
            od.setOrderDate(Calendar.getInstance().getTime());
            od.setItemId(item);
            od.setOrderId(order);
            od.setUnitPrice(item.getUnitPrice());
            od.setOrderQantity(Integer.parseInt(noOfUnits));
            od.setTotal(od.getUnitPrice().multiply(new BigDecimal(noOfUnits)));
            od.setBillId(1111);
            List<OrderDetail> odList = new ArrayList<>();
            odList.add(od);
            order.setOrderDetailCollection(odList);
            order.setTotal(od.getTotal());
            session.setAttribute("sessionOrder", order);
            RequestDispatcher rd = request.getRequestDispatcher("order_overview.jsp");
            rd.include(request, response);

        } else if (null != session.getAttribute("sessionOrder") && noOfUnits != null) {

            Order existingOrder = (Order) session.getAttribute("sessionOrder");
            //create order detail
            //check if item exist and add.
            OrderDetail od = new OrderDetail();
            od.setOrderDate(Calendar.getInstance().getTime());
            od.setItemId(item);
            od.setOrderQantity(Integer.parseInt(noOfUnits));
            boolean isCOnsolidated = consolidateOrder(existingOrder.getOrderDetailCollection(),od);
            od.setOrderId(existingOrder);
            od.setUnitPrice(item.getUnitPrice());
            
            od.setBillId(11411);
            if(!isCOnsolidated){
            od.setOrderQantity(Integer.parseInt(noOfUnits));
            od.setTotal(od.getUnitPrice().multiply(new BigDecimal(noOfUnits)));
            existingOrder.getOrderDetailCollection().add(od);
            }
            existingOrder.setTotal(InventoryUtils.calculateOrderTotal(existingOrder));
            session.setAttribute("sessionOrder", existingOrder);
            RequestDispatcher rd = request.getRequestDispatcher("order_overview.jsp");
            rd.include(request, response);

        }

    }

    private static boolean consolidateOrder(Collection<OrderDetail> orders, OrderDetail order) {
        boolean isCOnsolidated = false;
        for (OrderDetail od : orders) {
            if(od.getItemId().getId().equals(order.getItemId().getId())){
                Integer newNumberOfUnits = order.getOrderQantity();
                od.setOrderQantity(od.getOrderQantity()+newNumberOfUnits);
                od.setTotal(od.getUnitPrice().multiply(new BigDecimal(od.getOrderQantity())));
                isCOnsolidated=true;
            }
        }
        return isCOnsolidated;
    }
    
  

}
