package pc.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.ModelAttribute;
import pc.Model.Email;
import pc.Service.EmailService;

@Controller
public class MailController {

    private final EmailService emailService;

    public MailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @GetMapping("/sendMail")
    public String sendMailPage() {
        return "sendMail";
    }

    @PostMapping("/sendMail")
    public String sendMail(@ModelAttribute Email email, HttpSession session) {
        emailService.sendMail(email);
        session.setAttribute("msg", "Email sent successfully");
        return "sendMail";
    }
}
