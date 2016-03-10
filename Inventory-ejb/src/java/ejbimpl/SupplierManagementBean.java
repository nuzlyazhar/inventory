/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbimpl;

import ejb.SupplierManagementEJB;
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
public class SupplierManagementBean implements SupplierManagementEJB {

    @PersistenceContext
    EntityManager em;

    @Override
    public Supplier createSupplier(Supplier sup) {
        Supplier supplier = em.merge(sup);
        em.flush();
        return supplier;
    }
    
    @Override
    public List<Supplier> findAllSuppliers(){
        List<Supplier>  suppliers = em.createNamedQuery("Supplier.findAll", Supplier.class).getResultList();
        return suppliers;
                
    
    }
    
    @Override
    public Supplier findSupplierByName(String name){
       return em.createNamedQuery("Supplier.findByCompName", Supplier.class).setParameter("compName", name).getSingleResult();
    }
    
    @Override
    public Supplier findSupplierById(int id){
       return em.createNamedQuery("Supplier.findById", Supplier.class).setParameter("id", id).getSingleResult();
    }
}
