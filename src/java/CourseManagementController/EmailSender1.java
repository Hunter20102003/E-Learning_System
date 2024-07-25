package CourseManagementController;

import static CourseManagementController.EmailSender.sendJoinCourseEmail;
import static CourseManagementController.EmailSender.sendLeaveCourseEmail;
import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import java.util.Properties;

public class EmailSender1 {

    private static final String USERNAME = "nanaye8877@gmail.com"; // Thay bằng email của bạn
    private static final String PASSWORD = "zcku mnfl sfdl eroi"; // Thay bằng mật khẩu ứng dụng của bạn

    public static void sendLockCourseEmail(String toEmail, String courseName) {
        String subject = "Notification!";
        String messageContent = String.format("The course %s has been locked. You can still access your course at My Learning.", courseName);
        sendEmail(toEmail, subject, messageContent);
    }

    private static void sendEmail(String toEmail, String subject, String messageContent) {
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.ssl.trust", "*"); // Bỏ qua xác thực SSL

        // Tạo phiên gửi email
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(USERNAME, PASSWORD);
            }
        });

        try {
            // Tạo email
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(USERNAME));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject(subject);
            message.setText(messageContent);

            // Gửi email
            Transport.send(message);
            System.out.println("Email sent successfully to " + toEmail);

        } catch (MessagingException e) {
            System.out.println("Failed to send email to " + toEmail + ": " + e.getMessage());
        }
    }


    public static void main(String[] args) {
        // Thử nghiệm gửi email khi khóa học bị khóa
        sendLockCourseEmail("giaxuyen66@gmail.com", "Java Programming");
    }
}
