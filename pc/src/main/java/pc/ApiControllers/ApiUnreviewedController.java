package pc.ApiControllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pc.Model.Paper;
import pc.Model.Reviewer;
import pc.Service.PaperService;
import pc.Service.ReviewersService;
import pc.Data.PaperRepository;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ApiUnreviewedController {

    @Autowired
    private PaperService paperService;
    
    @Autowired
    private PaperRepository paperRepository;

    @Autowired
    private ReviewersService reviewersService;

    @GetMapping("/unreviewedpapers")
    public ResponseEntity<List<Paper>> getAllUnreviewedPapers() {
        List<Paper> unreviewedPapers = paperService.getPapersByStatus("unreviewed");
        return ResponseEntity.ok(unreviewedPapers);
    }

    @GetMapping("/unreviewed/reviewers")
    public ResponseEntity<List<Reviewer>> getAllReviewers() {
        List<Reviewer> reviewersList = reviewersService.getAllReviewers();
        return ResponseEntity.ok(reviewersList);
    }

    @PutMapping("/papers/{id}/reviewed")
    public ResponseEntity<String> markPaperAsReviewed(@PathVariable("id") Long id) {
        Paper paper = paperRepository.findById(id).orElse(null);
        if (paper == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Paper not found with ID: " + id);
        }
        paper.setStatus("reviewed");
        paperRepository.save(paper);
        return ResponseEntity.ok("Paper with ID " + id + " marked as reviewed.");
    }
}