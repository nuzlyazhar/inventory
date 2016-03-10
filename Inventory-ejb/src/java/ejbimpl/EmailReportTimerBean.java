/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbimpl;

import ejb.EmailReportTimerBeanLocal;
import ejb.OrderProcessorEJB;
import entity.Order;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import utils.EmailUtils;

/**
 *
 * @author nuzly
 */
@Stateless
public class EmailReportTimerBean implements EmailReportTimerBeanLocal {

    @EJB
    OrderProcessorEJB orderProcessorBean;

    @Schedule(hour = "*", minute = "*")
    @Override
    public void myTimer() {
        excute();
        System.out.println("Timer event: " + new Date());
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public void excute() {
        List<Order> all = orderProcessorBean.findAll("orderDate");
        String message = "<div style=\"color:blue;\">Hi Administrator, <br></br>Report for the month of march is generated below.</div>";
        StringBuilder result = new StringBuilder();

        result = result.append(message).append("<table border=\"1\">\n"
                + "<tr>\n"
                + "<th>Order id</th>\n"
                + "<th>Customer Name</th>\n"
                + "<th>Officer In charge</th>\n"
                + "<th>Order Date</th>\n"
                + "<th>Order Value</th>\n"
                + "</tr>\n"
        );
        for (Order o : all) {

            result.append("<tr><td>").append(o.getId()).append("</td><td>")
                    .append(o.getCustomerId().getFirstName()).append("</td><td>").append(o.getStaffId().getFirstName()).append("</td><td>").append(o.getOrderDate().toString()).append("</td><td>").append("SGD " + o.getTotal())
                    .append("</td></tr>");

        }
        result.append("</table>");
        //result.append("<tr><td>").append("test").append("</td><td>").append("test2").append("</td></tr>").append("</table>");
        Calendar cal = Calendar.getInstance();
        String month = new SimpleDateFormat("MMMM").format(cal.getTime());
        int year = cal.get(Calendar.YEAR);
        String subject = "Order Summary Report for " + month+" "+year;
        //EmailUtils.sendEmail("hub.dani@gmail.com", subject, result.toString(), EmailUtils.HTML);
        //EmailUtils.sendEmail("snipergacp@gmail.com", subject, result.toString(), EmailUtils.HTML);
       // EmailUtils.sendEmail("mariyam.amna@gmail.com", subject, result.toString(), EmailUtils.HTML);
//       EmailUtils.sendEmail("nuskyazhar@gmail.com", subject, result.toString(), EmailUtils.HTML);

    }
}
