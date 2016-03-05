/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Customer;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author nuzly
 */
@Stateless
public class CustomerManagementBean {
    
    @PersistenceContext
    EntityManager em;
    
     public Customer createItem(Customer c) {
        Customer i = em.merge(c);
        em.flush();;
        return i;

    }
     
     public List<Customer> findAll(){
         List<Customer> customers = em.createNamedQuery("Customer.findAll", Customer.class).getResultList();
         return customers;
     
     }
     
     public Customer findById(String id){
     Customer customer = em.createNamedQuery("Customer.findById", Customer.class).setParameter("id", Integer.parseInt(id)).getSingleResult();
     return customer;
     }
 }
