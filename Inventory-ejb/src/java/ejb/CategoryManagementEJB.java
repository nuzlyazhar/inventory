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

    Category createCategory(Category cat);

    List<Category> findAll();

    Category findCategoryById(Integer id);

    Category findCategoryByName(Integer catName);
    
}
