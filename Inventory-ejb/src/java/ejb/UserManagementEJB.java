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
 *
 * @author nuzly
 */
public interface UserManagementEJB {

    User approveUser(String id);

    void createUser(User u);

    User findByUsername(String userName);

    @Asynchronous
    void sendUserEmail(User approvedUser);

    //Used by sys admin
    List<User> usersPendingApproval();

    boolean validateUser(User u, String password);
    
}
