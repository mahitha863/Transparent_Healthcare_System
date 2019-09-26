/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.THCSManagerRole;

/**
 *
 * @author gayathri
 */
import java.io.UnsupportedEncodingException;
import java.util.Date;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class EmailUtil {

    /**
     * Utility method to send simple HTML email
     *
     * @param session
     * @param toEmail
     * @param subject
     * @param body
     */
    public static void sendEmail(Session session, String toEmail, String subject, String body) {
        try {
            MimeMessage msg = new MimeMessage(session);
            //set message headers
            msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
            msg.addHeader("format", "flowed");
            msg.addHeader("Content-Transfer-Encoding", "8bit");
            msg.setFrom(new InternetAddress("no_reply@THCS.com", "NoReply-THCS"));
            msg.setReplyTo(InternetAddress.parse("no_reply@THCS.com", false));
            msg.setSubject(subject, "UTF-8");
            msg.setText(body, "UTF-8");
            msg.setSentDate(new Date());
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
            
            System.out.println("Message is ready");
            Transport.send(msg);
            System.out.println("EMail Sent Successfully!!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Utility method to send email with attachment
     *
     * @param session
     * @param toEmail
     * @param subject
     * @param body
     */
    public static boolean sendAttachmentEmail(Session session, String toEmail, String subject, String body, String reportType) {
        boolean successFlag = false;
        try {
            MimeMessage msg = new MimeMessage(session);
            msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
            msg.addHeader("format", "flowed");
            msg.addHeader("Content-Transfer-Encoding", "8bit");
            msg.setFrom(new InternetAddress("no_reply@THCS.com", "NoReply-THCS"));
            msg.setReplyTo(InternetAddress.parse("no_reply@THCS.com", false));
            msg.setSubject(subject, "UTF-8");
            msg.setSentDate(new Date());
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));

            // Create the message body part
            BodyPart messageBodyPart = new MimeBodyPart();
            // Fill the message
            messageBodyPart.setText(body);
            // Create a multipart message for attachment
            Multipart multipart = new MimeMultipart();
            // Set text message part
            multipart.addBodyPart(messageBodyPart);
            // Second part is attachment
            messageBodyPart = new MimeBodyPart();
            String path = "Reporthospitals.pdf";
            if(reportType.equals("hospitals")){
                path = "Reporthospitals.pdf";
            }else{
                path = "Reportnetworks.pdf";
            }
            DataSource source = new FileDataSource(path);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(path);
            multipart.addBodyPart(messageBodyPart);
            // Send the complete message parts
            msg.setContent(multipart);
            // Send message
            Transport.send(msg);
            System.out.println("EMail Sent Successfully with attachment!!");
            successFlag = true;
        } catch (MessagingException e) {
            e.printStackTrace();
            successFlag = false;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            successFlag = false;
        }
        
        return successFlag;
    }

}
