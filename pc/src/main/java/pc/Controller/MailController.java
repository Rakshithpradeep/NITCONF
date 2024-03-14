package pc.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import pc.Model.Email;
import pc.Model.Reviewer;
import pc.Service.EmailService;
import pc.Service.ReviewersService;

@Controller
public class MailController {

    @Autowired
    private ReviewersService reviewersService;

    @Autowired
    private EmailService emailService;

    @GetMapping("/sendMail")
    public String showEmailForm(Model model) {
        // Retrieve all reviewers briur9uo
        model.addAttribute("reviewers", reviewersService.getAllReviewers());
        // Initialize an empty Email object
        model.addAttribute("email", new Email());
        return "sendMail";
    }

    @PostMapping("/sendMail")
    public String sendEmail(@ModelAttribute("email") Email email) {
        // Send the email here
        emailService.sendMail(email);
        // Redirect to a success page or any other desired page
        return "discussions";
    }
}
