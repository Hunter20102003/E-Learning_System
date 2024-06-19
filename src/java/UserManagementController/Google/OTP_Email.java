/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package UserManagementController.Google;
import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import jakarta.servlet.http.HttpServlet;
import java.security.SecureRandom;
import java.util.Properties;

/**
 *
 * @author LEGION
 */
public class OTP_Email extends HttpServlet {

   
    private static final String CHARACTERS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final int OTP_LENGTH = 5;

    public static String generateOTP() {
        SecureRandom random = new SecureRandom();
        StringBuilder otp = new StringBuilder();

        for (int i = 0; i < OTP_LENGTH; i++) {
            int randomIndex = random.nextInt(CHARACTERS.length());
            char randomChar = CHARACTERS.charAt(randomIndex);
            otp.append(randomChar);
        }

        return otp.toString();
    }
 public String sendMessageMail(String mail,String mes) {
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.ssl.protocols", "TLSv1.2");

        // Tạo phiên gửi email
        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("nanaye8877@gmail.com", "zcku mnfl sfdl eroi");
            }
        });

        try {
          
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("nanaye8877@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mail));
            message.setSubject("Verify email");
            message.setText(mes);

            // Gửi email
            Transport.send(message);
            return mes;
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String sendOtpMail(String mail) {
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.ssl.protocols", "TLSv1.2");

        // Tạo phiên gửi email
        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("nanaye8877@gmail.com", "zcku mnfl sfdl eroi");
            }
        });

        try {
            // Tạo email
            String otp = generateOTP();
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("nanaye8877@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mail));
            message.setSubject("Verify email");
            message.setText(otp);

            // Gửi email
            Transport.send(message);
            return otp;
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return null;
    }

    
   

}
