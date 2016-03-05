/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Supplier;
import java.util.List;

/**
 *
 * @author nuzly
 */
public interface SupplierManagementEJB {

    Supplier createSupplier(Supplier sup);

    List<Supplier> findAllSuppliers();

    Supplier findSupplierByName(String name);
    
}
