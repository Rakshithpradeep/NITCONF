package pc.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import pc.Data.UnReviewedPapersRepository;
import pc.Model.UnReviewedPapers;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/UnReviewedPapers")
public class UnReviewedPapersController {
    
	
    @Autowired
    private UnReviewedPapersRepository paperRepository;

    @GetMapping("/")
    public ResponseEntity<List<UnReviewedPapers>> getAllPapers() {
        List<UnReviewedPapers> papers = paperRepository.findAll();
        return new ResponseEntity<>(papers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UnReviewedPapers> getPaperById(@PathVariable("id") Long id) {
        Optional<UnReviewedPapers> paperOptional = paperRepository.findById(id);
        return paperOptional.map(paper -> new ResponseEntity<>(paper, HttpStatus.OK))
                             .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/")
    public ResponseEntity<UnReviewedPapers> createPaper(@RequestBody UnReviewedPapers paper) {
    	UnReviewedPapers savedPaper = paperRepository.save(paper);
        return new ResponseEntity<>(savedPaper, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UnReviewedPapers> updatePaper(@PathVariable("id") Long id, @RequestBody UnReviewedPapers paper) {
        if (!paperRepository.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        paper.setId(id);
        UnReviewedPapers updatedPaper = paperRepository.save(paper);
        return new ResponseEntity<>(updatedPaper, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePaper(@PathVariable("id") Long id) {
        if (!paperRepository.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        paperRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
