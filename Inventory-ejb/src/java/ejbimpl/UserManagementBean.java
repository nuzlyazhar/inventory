/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbimpl;

import ejb.UserManagementEJB;
import entity.User;
import java.util.List;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import utils.Constants;
import utils.EmailUtils;

/**
 *
 * @author nuzly
 */
@Stateless
public class UserManagementBean implements UserManagementEJB {

    @PersistenceContext
    EntityManager em;

    @Override
    public void createUser(User u) {
        System.out.println(u);
        em.merge(u);
        em.flush();

    }

    @Override
    public User findByUsername(String userName) {
        Query query = em.createQuery("SELECT u FROM User u WHERE u.username = ?1 ");
        query.setParameter(1, userName);
        try {
            User u = (User) query.getSingleResult();
            return u;
        } catch (Exception e) {
            return null;
        }

    }

    @Override
    public boolean validateUser(User u, String password) {
        boolean valid = false;
        if (password != null && password.equals(u.getPassword())) {
            if (Constants.APPROVED.equals(u.getStatus())) {
                valid = true;
            }
        }
        return valid;
    }

    //Used by sys admin
    @Override
    public List<User> usersPendingApproval() {
        Query query = em.createQuery("SELECT u FROM User u WHERE u.status <> ?1 OR u.status is null ");
        query.setParameter(1, Constants.APPROVED);

        List<User> usersPendingApproval = query.getResultList();
        return usersPendingApproval;

    }
    
    @Override
    public User approveUser(String id){
        User user = em.find(User.class, Integer.valueOf(id));
        user.setStatus(Constants.APPROVED);
        user.setRole(Constants.STAFF_ROLE);
        user = em.merge(user);
        em.flush();
        return user;
    
    }
    @Asynchronous
    @Override
    public void sendUserEmail(User approvedUser){
    
    String emailText = Constants.HI+approvedUser.getFirstName()+Constants.APPROVAL_EMAIL_CONTENT;
        EmailUtils.sendEmail(approvedUser.getEmail(), Constants.APPROVL_EMAIL_SUBJECT, emailText,null);
    }
    
   
}
