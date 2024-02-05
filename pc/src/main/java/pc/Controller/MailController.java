package pc.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpSession;
import pc.Model.Email;
import pc.Service.EmailService;

/**
 * Controller class for handling requests related to sending emails.
 */
@Controller
public class MailController {

    @Autowired
    private EmailService emailService;

    /**
     * Handles the GET request for "/sendMail" endpoint to display the sendMail page.
     *
     * @return The view name for the sendMail page.
     */
    @GetMapping("/sendMail")
    public String sendMailPage() {
        return "sendMail";
    }

    /**
     * Handles the POST request for "/sendMail" endpoint to send an email.
     *
     * @param email   The Email object containing the email details.
     * @param session The HTTP session.
     * @return The view name for the sendMail page.
     */
    @PostMapping("/sendMail")
    public String sendMail(@ModelAttribute Email email, HttpSession session) {
        // Send the email using the EmailService
        emailService.sendMail(email);

        // Set a session attribute for success message
        session.setAttribute("msg", "Email sent successfully");

        // Return the view name for the sendMail page
        return "sendMail";
    }
}
