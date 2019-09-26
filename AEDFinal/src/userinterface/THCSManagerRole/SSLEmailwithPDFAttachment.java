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
import java.io.FileOutputStream;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class SSLEmailwithPDFAttachment {

    public static boolean createPDF(String path, String fileName) {
        boolean b = false;
        
        List imagesList = new ArrayList<String>();
        try (Stream<Path> filePathStream=Files.walk(Paths.get(path))) {
            filePathStream.forEach(filePath -> {
                if (Files.isRegularFile(filePath)) {
                    imagesList.add(filePath);
                }
            });
        }   catch (IOException ex) {
                Logger.getLogger(SSLEmailwithPDFAttachment.class.getName()).log(Level.SEVERE, null, ex);
            }
        

        try {

            Image img = Image.getInstance(imagesList.get(0).toString());
            Document document = new Document(img);
            PdfWriter.getInstance(document, new FileOutputStream(fileName));
            document.open();
            for (Object image : imagesList) {
                img = Image.getInstance(image.toString());
                document.setPageSize(img);
                document.newPage();
                img.setAbsolutePosition(0, 0);
                document.add(img);
            }
            document.close();
            b = true;

        } catch (Exception ex) {
            // Logger.getLogger(Prescrip    tionTimer.class.getName()).log(Level.SEVERE, null, ex);
        }

        return b;
    }

    /**
     * Outgoing Mail (SMTP) Server requires TLS or SSL: smtp.gmail.com (use
     * authentication) Use Authentication: Yes Port for SSL: 465
     */
    public boolean sendEmail(String email, String networkName) {
        boolean successFlag1 = false;
        boolean successFlag2 = false;

        final String fromEmail = "gayathri.thammana1837@gmail.com"; //requires valid gmail id
        final String password = "Gayathri@264"; // correct password for gmail id
        final String toEmail = email; // can be any email id 

        System.out.println("SSLEmail Start");
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
        props.put("mail.smtp.socketFactory.port", "465"); //SSL Port
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory"); //SSL Factory Class
        props.put("mail.smtp.auth", "true"); //Enabling SMTP Authentication
        props.put("mail.smtp.port", "465"); //SMTP Port

        Authenticator auth = new Authenticator() {
            //override the getPasswordAuthentication method
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        };

        Session session = Session.getDefaultInstance(props, auth);
        System.out.println("Session created");

        boolean pdf1 = createPDF("snapshotsHospitals", "Reporthospitals.pdf");
        boolean pdf2 = createPDF("snapshotsNetworks", "Reportnetworks.pdf");
        
        String emailTitle = null;
        if (pdf1) {
            emailTitle = "Health costs comparison across all hospitals in " + networkName + " State";
            successFlag1 = EmailUtil.sendAttachmentEmail(session, toEmail, emailTitle , emailTitle, "hospitals");
        }
        
        if(pdf2){
            emailTitle = "Health costs comparison across all US states";
            successFlag2 = EmailUtil.sendAttachmentEmail(session, toEmail, emailTitle, emailTitle, "networks");           
        }
        
        return (successFlag1 && successFlag1);
    }

}
