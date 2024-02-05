package pc.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.internet.MimeMessage;
import pc.Model.Email;

/**
 * Service class for handling email-related functionality.
 */
@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    /**
     * Sends an email using the provided Email object.
     *
     * @param em The Email object containing email details.
     */
    public void sendMail(Email em) {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message);

            // Set the sender's email address
            helper.setFrom("rakshithpradeep1234@gmail.com");

            // Set the recipient's email address
            helper.setTo(em.getTo());

            // Set the subject of the email
            helper.setSubject(em.getSubject());

            // Set the content of the email
            helper.setText(em.getMessage());

            // Send the email
            javaMailSender.send(message);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
