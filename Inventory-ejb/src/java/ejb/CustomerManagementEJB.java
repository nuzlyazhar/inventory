/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Customer;
import java.util.List;

/**
 * EJB for customer management.
 * @author nuzly
 */
public interface CustomerManagementEJB {
    
    /**
     * creates a customer
     * @param c
     * @return 
     */
    Customer createItem(Customer c);
    
    /**
     * Find all customers
     * @return 
     */
    List<Customer> findAll();

    /**
     * Find customer by id
     * @param id
     * @return  
     */
    Customer findById(String id);
    
}
