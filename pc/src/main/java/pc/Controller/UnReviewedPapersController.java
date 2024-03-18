package pc.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin; // Import CrossOrigin annotation

import pc.Model.Paper;
import pc.Service.PaperService;
import pc.Service.ReviewersService;
import pc.Data.PaperRepository;
import pc.Model.Reviewer; // Import Reviewer model

import java.util.List;
import java.util.Map;

/**
 * Controller class for handling requests related to reviewed papers.
 */
@Controller
public class UnReviewedPapersController {

    @Autowired
    private PaperService paperService;
    
    @Autowired
    private PaperRepository paperRepository;

    @Autowired
    private ReviewersService reviewersService; // Inject ReviewersService

    /**
     * Handles the GET request for "/unreviewedpapers" endpoint.
     *
     * @param model The model to add attributes for rendering in the view.
     * @return The view name for the reviewed papers page.
     */
    @GetMapping("/unreviewedpapers")
    public String getAllPapers(Model model) {
        // Retrieve all unreviewed papers from the database
    	System.out.println("hell0");
        List<Paper> unreviewedPapers = paperService.getPapersByStatus("unreviewed");

        // Retrieve all reviewers
        List<Reviewer> reviewersList = reviewersService.getAllReviewers();

        // Add the list of unreviewed papers to the model
        model.addAttribute("unreviewedPapers", unreviewedPapers);
        
        // Add the list of reviewers to the model
        model.addAttribute("reviewersList", reviewersList);

        // Return the view name for the unreviewed papers page
        return "unreviewedpapers";
    }
    
   
    @PutMapping("/papers/{id}/reviewed")
    @CrossOrigin // Add CrossOrigin annotation to allow requests from different origins
    @ResponseBody
    public ResponseEntity<String> markPaperAsReviewed(@PathVariable("id") Long id) {
        // Find the paper by its ID
        Paper paper = paperRepository.findById(id).orElse(null);

        if (paper == null) {
            // If paper not found, return 404 Not Found
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Paper not found with ID: " + id);
        }

        // Update the status of the paper to "reviewed"
        paper.setStatus("reviewed");
        paperRepository.save(paper);

        // Return a success message
        return ResponseEntity.ok("Paper with ID " + id + " marked as reviewed.");
    }
}
