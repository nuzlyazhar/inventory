/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Supplier;
import java.util.List;

/**
 * EJB for Supplier management,
 * @author nuzly
 */
public interface SupplierManagementEJB {

    /**
     * create Supplier
     * @param sup
     * @return
     */
    Supplier createSupplier(Supplier sup);
    
    /**
     * find All Suppliers
     * @return 
     */
    List<Supplier> findAllSuppliers();
    
    /**
     * find Supplier By Name
     * @param name
     * @return 
     */
    Supplier findSupplierByName(String name);

    /**
     * find Supplier By Id
     * @param id
     * @return 
     */
    public Supplier findSupplierById(int id);
}
