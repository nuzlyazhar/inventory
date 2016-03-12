/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Order;
import java.util.List;

/**
 * EJB for Order management.
 * @author nuzly
 */
public interface OrderProcessorEJB {

    /**
     * create Order
     * @param order
     * @return 
     */
    Order createOrder(Order order);

    /**
     * find All orders
     * @param orderBy
     * @return 
     */
    List<Order> findAll(String orderBy);

    /**
     * Process the order and persist.
     * @param order 
     */
    void processOrder(Order order);
    
}
