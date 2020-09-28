/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


/**
 *
 * @author Dinamo
 */
class SendingEmail {
    private String userEmail;
    private String myHash;
    
    public SendingEmail(String userEmail, String myHash){
    this.userEmail = userEmail;
    this.myHash = myHash;
    }
    public void sendEmail(){
            String email = "personaswebapp2020@gmail.com";           
            String pword = "Alexandru-1";
            Properties properties = new Properties();
            properties.put("mail.smtp.auth", "true");
            properties.put("mail.smtp.starttls.enable", "true");
            properties.put("mail.smtp.host", "smtp.gmail.com");
            properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
            properties.put("mail.smtp.port", "587");
            
          

        Session session = Session.getInstance(properties,
          new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(email, pword);
            }
          });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(email));
            message.setRecipients(Message.RecipientType.TO,    InternetAddress.parse(userEmail));
            message.setSubject("Personas Email Verification Link");
            message.setText("Verification Link...");
            message.setText("Your verification Link ::"+"http://localhost:14512/Personas/ActivateAccount?key1="+userEmail+"&key2="+myHash);


            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
            
//            
//            Session session = Session.getInstance(properties,
//          new javax.mail.Authenticator() {
//            @Override
//            protected PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication(email, pword);
//            }
//          });
//
//        try {
//            Message message = new MimeMessage(session);
//            message.setFrom(new InternetAddress(email));
//            message.setRecipients(Message.RecipientType.TO,
//                InternetAddress.parse(userEmail));
//            message.setSubject("Personas Email Verification Link");
//            message.setText("Verification Link...");
//            message.setText("Your verification Link ::"+"http://localhost:14512/Personas/ActivateAccount?key1="+userEmail+"&key2="+myHash);
//
//            Transport.send(message);
//
//            System.out.println("Done");
//
//        } catch (MessagingException e) {
//            throw new RuntimeException(e);
//        }
         
//           Authenticator authenticator = new Authenticator(){
//               @Override
//               protected PasswordAuthentication getPasswordAuthentication() {
//			return new PasswordAuthentication(email, pword);
//		}
//           };
//           
//            Session session = Session.getDefaultInstance(properties, authenticator);
//            
//            try{
//                MimeMessage message = new MimeMessage(session);
//                message.setFrom(new InternetAddress(email));
//                message.addRecipient(Message.RecipientType.TO, new InternetAddress(userEmail));
//                message.setSubject("Personas Email Verification Link");
//                message.setText("Verification Link...");
//                message.setText("Your verification Link ::"+"http://localhost:14512/Personas/ActivateAccount?key1="+userEmail+"&key2="+myHash);
//                Transport.send(message);
//                
//            }catch(Exception ex){
//                System.out.println("Sending email..."+ex);
//            }
    }
}
