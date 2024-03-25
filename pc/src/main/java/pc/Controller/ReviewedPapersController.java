package pc.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ResponseBody;

import pc.Model.Paper;
import pc.Service.PaperService;
import pc.Data.PaperRepository;
import pc.Service.EmailService;
import pc.Model.Email;

import java.util.List;
import java.util.Optional;

@Controller
public class ReviewedPapersController {

    @Autowired
    private PaperService paperService;

    @Autowired
    private PaperRepository paperRepository;

    @Autowired
    private EmailService emailService;

    @GetMapping("/reviewedpapers")
    public String getAllPapers(Model model) {
        List<Paper> reviewedPapers = paperService.getPapersByStatus("reviewed");
        model.addAttribute("reviewedPapers", reviewedPapers);
        return "reviewedpapers";
    }

    @PutMapping("/updatePaperStatus/{paperId}/{decision}")
    @CrossOrigin
    @ResponseBody
    public ResponseEntity<String> updatePaperStatus(@PathVariable("paperId") Long paperId, @PathVariable("decision") String decision, String comments) {
        Optional<Paper> optionalPaper = paperRepository.findById(paperId);
        if (optionalPaper.isPresent()) {
            Paper paper = optionalPaper.get();
            if (decision.equals("accept")) {
                paper.setStatus("accepted");
                sendNotificationEmail(paper.getEmail(), "Paper Accepted", "Your paper has been accepted.",comments);
            } else if (decision.equals("reject")) {
                paper.setStatus("rejected");
                sendNotificationEmail(paper.getEmail(), "Paper Rejected", "Your paper has been rejected.",comments);
            }
            paperRepository.save(paper);
            return new ResponseEntity<>("Paper status updated successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Paper not found", HttpStatus.NOT_FOUND);
        }
    }

    private void sendNotificationEmail(String recipientEmail, String subject, String message, String comments) {
        // Construct the email message including comments
        StringBuilder fullMessage = new StringBuilder();
        fullMessage.append(message);
        fullMessage.append("\n\nComments: ");
        //fullMessage.append(comments);

        // Create an Email object
        Email email = new Email();
        email.setTo(recipientEmail);
        email.setSubject(subject);
        email.setMessage(fullMessage.toString());

        // Send the email
        emailService.sendMail(email);
    }
}
