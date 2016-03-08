/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbimpl;

import ejb.ItemManagementEJB;
import entity.Item;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import utils.InventoryUtils;

/**
 *
 * @author nuzly
 */
@Stateless
public class ItemManagementBean implements ItemManagementEJB {

    @PersistenceContext
    EntityManager em;

    @Override
    public Item createItem(Item item) {
        Item i = em.merge(item);
        em.flush();;
        return i;

    }

    @Override
    public List<Item> findAllItems() {
        List<Item> itemsList = em.createNamedQuery("Item.findAll", Item.class).getResultList();
        return itemsList;

    }

    @Override
    public Item getItemById(String id) {
        Item item = em.createNamedQuery("Item.findById", Item.class).setParameter("id", Integer.parseInt(id)).getSingleResult();
        return item;

    }
    
    @Override
    public List<Item> findAllItemsBelowReorderThreshold() {
        List<Item> itemsList = em.createNamedQuery("Item.findBelowReorderThreshold", Item.class).getResultList();
        return itemsList;

    }

    @Override
    public List<Item> searchItems(Item item) {

        TypedQuery<Item> query = em.createQuery("SELECT i FROM Item i WHERE UPPER(i.itemName) LIKE :keyword ORDER BY i.itemName", Item.class);
        query.setParameter("keyword", "%" + item.getItemName().toUpperCase() + "%");
        List<Item> itemResults = query.getResultList();
        return itemResults;

    }

    @Override
    public Item searchItemByName(String itemName) {

        TypedQuery<Item> query = em.createNamedQuery("Item.findByItemName", Item.class);
        query.setParameter("itemName", itemName);
        Item itemResults = query.getSingleResult();
        return itemResults;

    }

    @Override
    public List<Item> searchItem(Map<String, Object> queryParameters) {
        
        CriteriaBuilder cb = em.getCriteriaBuilder();
        final List<Predicate> predicates = new ArrayList<Predicate>();

        CriteriaQuery<Item> query = cb.createQuery(Item.class);
        Root<Item> root = query.from(Item.class);
        if (queryParameters != null && !queryParameters.isEmpty()) {
            // Predicate condition = null;//cb.equal(root.get("itemName"), "iame");
            for (String parameter : queryParameters.keySet()) {
                Object parmValue = queryParameters.get(parameter);
                if (null != parmValue && !"".equals(parmValue)) {
                    predicates.add(cb.equal(root.get(parameter), parmValue));
                }
            }
            query.where(cb.and(predicates.toArray(new Predicate[predicates.size()])));

        }

        List<Item> items  = em.createQuery(query).getResultList();
        return items;

    }

}
