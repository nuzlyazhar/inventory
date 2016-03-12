/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Category;
import java.util.List;

/**
 * EJB for Category management.
 * @author nuzly
 */

public interface CategoryManagementEJB {
    /**
     * Creates a Category
     * @param cat
     * @return created category
     */
    Category createCategory(Category cat);

    /**
     * 
     * @return All categories
     */
    List<Category> findAll();
    
    /**
     * find Category By Id
     * @param id
     * @return 
     */
    Category findCategoryById(Integer id);

    /**
     * Finds category by its name.
     * @param catName
     * @return 
     */
    Category findCategoryByName(String catName);
    
}
