/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Category;
import java.util.List;

/**
 *
 * @author nuzly
 */

public interface CategoryManagementEJB {
    /**
     * 
     * @param cat
     * @return created category
     */
    Category createCategory(Category cat);

    /**
     * 
     * @return All categories
     */
    List<Category> findAll();

    Category findCategoryById(Integer id);

    Category findCategoryByName(String catName);
    
}
