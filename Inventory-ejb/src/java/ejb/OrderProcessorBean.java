/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Item;
import entity.Order;
import entity.OrderDetail;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author nuzly
 */
@Stateless
public class OrderProcessorBean {

    @PersistenceContext
    EntityManager em;

    @EJB
    ItemManagementBean itemManagementBean;

    public Order createOrder(Order order) {
        Order ord = em.merge(order);
        return ord;
    }

    public void processOrder(Order order) {

        for (OrderDetail od : order.getOrderDetailCollection()) {
            Item i = od.getItemId();
            i.setUnitsInOrder(i.getUnitsInOrder() + od.getOrderQantity());
            i.setUnitsInStock(i.getUnitsInStock() - od.getOrderQantity());
            itemManagementBean.createItem(i);
            od.setItemId(i);
            

        }
        
        createOrder(order);

    }

    public List<Order> findAll(String orderBy) {
        List<Order> orderList = em.createQuery("SELECT o FROM Order o order by o." + orderBy, Order.class).getResultList();
        return orderList;
    }

}
