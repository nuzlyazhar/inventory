/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import entity.Order;
import entity.OrderDetail;
import java.math.BigDecimal;

/**
 *
 * @author nuzly
 */
public class InventoryUtils {

    public static boolean isEmpty(String value) {
        return (null == value || "".equals(value));
    }

    public static boolean isNotEmpty(String value) {
        return (null != value && !"".equals(value));
    }
    
        public static BigDecimal calculateOrderTotal(Order order) {
        BigDecimal total = new BigDecimal("0.00");
        for (OrderDetail od : order.getOrderDetailCollection()) {
            total = total.add(od.getTotal());
        }
        return total;
    }

}
