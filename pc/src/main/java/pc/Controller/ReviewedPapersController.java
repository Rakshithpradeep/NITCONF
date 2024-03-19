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

import java.util.List;
import java.util.Optional;

@Controller
public class ReviewedPapersController {

    @Autowired
    private PaperService paperService;

    @Autowired
    private PaperRepository paperRepository;
//retrive all the papers to display
    @GetMapping("/reviewedpapers")
    public String getAllPapers(Model model) {
        List<Paper> reviewedPapers = paperService.getPapersByStatus("reviewed");
        model.addAttribute("reviewedPapers", reviewedPapers);
        return "reviewedpapers";
    }
   
  //for updating status of the paper to accepted
    @PutMapping("/updatePaperStatus/{paperId}/{decision}")
    @CrossOrigin
    @ResponseBody
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
