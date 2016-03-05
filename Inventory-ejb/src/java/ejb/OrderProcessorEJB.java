/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Order;
import java.util.List;

/**
 *
 * @author nuzly
 */
public interface OrderProcessorEJB {

    Order createOrder(Order order);

    List<Order> findAll(String orderBy);

    void processOrder(Order order);
    
}
