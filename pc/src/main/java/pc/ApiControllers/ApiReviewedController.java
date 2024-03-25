package pc.ApiControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pc.Model.Paper;
import pc.Service.PaperService;
import pc.Data.PaperRepository;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ApiReviewedController {

    @Autowired
    private PaperService paperService;

    @Autowired
    private PaperRepository paperRepository;

    @GetMapping("/reviewedpapers")
    public ResponseEntity<List<Paper>> getAllReviewedPapers() {
        List<Paper> reviewedPapers = paperService.getPapersByStatus("reviewed");
        return new ResponseEntity<>(reviewedPapers, HttpStatus.OK);
    }

    @PutMapping("/updatePaperStatus/{paperId}/{decision}")
    public ResponseEntity<String> updatePaperStatus(@PathVariable("paperId") Long paperId, @PathVariable("decision") String decision) {
        Optional<Paper> optionalPaper = paperRepository.findById(paperId);
        if (optionalPaper.isPresent()) {
            Paper paper = optionalPaper.get();
            if (decision.equals("accept")) {
                paper.setStatus("accepted");
            } else if (decision.equals("reject")) {
                paper.setStatus("rejected");
            }
            paperRepository.save(paper);
            return new ResponseEntity<>("Paper status updated successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Paper not found", HttpStatus.NOT_FOUND);
        }
    }
}