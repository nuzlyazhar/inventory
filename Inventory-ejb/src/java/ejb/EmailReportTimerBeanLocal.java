/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import javax.ejb.Local;

/**
 * EJB for Email report sending. Uses EJB 3.1 @Schedule
 * @author nuzly
 */
@Local
public interface EmailReportTimerBeanLocal {
    /**
     * The timer method to execute reports
     */
    public void myTimer();

    /**
     * Execute method which does the task
     */
    void excute();
}
