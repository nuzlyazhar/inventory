/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Customer;
import java.util.List;

/**
 *
 * @author nuzly
 */
public interface CustomerManagementEJB {

    Customer createItem(Customer c);

    List<Customer> findAll();

    Customer findById(String id);
    
}
