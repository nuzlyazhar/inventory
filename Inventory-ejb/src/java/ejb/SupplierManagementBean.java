/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Supplier;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author nuzly
 */
@Stateless
public class SupplierManagementBean {

    @PersistenceContext
    EntityManager em;

    public Supplier createSupplier(Supplier sup) {
        Supplier supplier = em.merge(sup);
        em.flush();
        return supplier;
    }
    
    public List<Supplier> findAllSuppliers(){
        List<Supplier>  suppliers = em.createNamedQuery("Supplier.findAll", Supplier.class).getResultList();
        return suppliers;
                
    
    }
    
    public Supplier findSupplierByName(String name){
       return em.createNamedQuery("Supplier.findByCompName", Supplier.class).setParameter("compName", name).getSingleResult();
    }
}
