/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Item;
import java.util.List;
import java.util.Map;

/**
 * EJB for item management.
 * @author nuzly
 */
public interface ItemManagementEJB {
    /**
     * createItem
     * @param item
     * @return 
     */
    Item createItem(Item item);

    /**
     * find All Items
     * @return 
     */
    List<Item> findAllItems();
    
    /**
     * Find AllI tems Below ReorderT hreshold
     * @return 
     */
    List<Item> findAllItemsBelowReorderThreshold();

    /**
     * get Item By Id
     * @param id
     * @return 
     */
    Item getItemById(String id);

    /**
     * search Item
     * @param queryParameters
     * @return 
     */
    List<Item> searchItem(Map<String, Object> queryParameters);

    /**
     * search Item By Name
     * @param itemName
     * @return 
     */
    Item searchItemByName(String itemName);
    
    /**
     * search Items by category, supplier and name. 
     * @param item
     * @return 
     */
    List<Item> searchItems(Item item);
    
}
