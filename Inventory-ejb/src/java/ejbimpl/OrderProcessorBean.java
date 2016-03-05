/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbimpl;

import ejb.OrderProcessorEJB;
import ejb.ItemManagementEJB;
import entity.Item;
import entity.Order;
import entity.OrderDetail;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import utils.InventoryUtils;

/**
 *
 * @author nuzly
 */
@Stateless
public class OrderProcessorBean implements OrderProcessorEJB {
    
    @PersistenceContext
    EntityManager em;
    
    @EJB
    ItemManagementEJB itemManagementBean;
    
    @Override
    public Order createOrder(Order order) {
        Order ord = em.merge(order);
        return ord;
    }
    
    @Override
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
    
    @Override
    public List<Order> findAll(String orderBy) {
        List<Order> orderList = em.createQuery("SELECT o FROM Order o order by o." + orderBy, Order.class).getResultList();
        for (Order o : orderList) {
            o.setTotal(InventoryUtils.calculateOrderTotal(o));
        }
        return orderList;
    }
    
}
