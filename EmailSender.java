import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailSender {
    public static void main(String[] args) {
        // Sender's email credentials
        final String senderEmail = "hemashan07@gmail.com";
        final String senderPassword = "zbns iqxf ingg jvbp";  // Use an App Password, NOT your Gmail password

        // Receiver's email
        String recipientEmail = "kesavanp136@gmail.com";

        // SMTP server configuration
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");  // Use 465 for SSL or 587 for TLS

        // Create session with authentication
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, senderPassword);
            }
        });

        try {
            // Create a message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
            message.setSubject("Test Email from Java");
            message.setText("Hello, this is a test email sent from Java using Gmail SMTP!");

            // Send email
            Transport.send(message);

            System.out.println("Email sent successfully!");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
