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
 *
 * @author nuzly
 */
public interface ItemManagementEJB {

    Item createItem(Item item);

    List<Item> findAllItems();

    List<Item> findAllItemsBelowReorderThreshold();

    Item getItemById(String id);

    List<Item> searchItem(Map<String, Object> queryParameters);

    Item searchItemByName(String itemName);

    List<Item> searchItems(Item item);
    
}
