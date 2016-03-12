/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.User;
import java.util.List;
import javax.ejb.Asynchronous;

/**
 * EJB for user management.
 * @author nuzly
 */
public interface UserManagementEJB {

    /**
     *  Approve user.
     * @param id
     * @return 
     */
    User approveUser(String id);
    
    /**
     * Create user.
     * @param u 
     */
    void createUser(User u);
    
    /**
     * find User By Username
     * @param userName
     * @return 
     */
    User findByUsername(String userName);
    
    /**
     * Find all users.
     * @return 
     */
    List<User> findALl();

    /**
     * Asynchronous method to send email.
     * @param approvedUser 
     */
    @Asynchronous
    void sendUserEmail(User approvedUser);

    //Used by sys admin
    List<User> usersPendingApproval();

    boolean validateUser(User u, String password);
    
}
