package pc.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import pc.Data.PaperRepository;
import pc.Model.Paper;

import java.util.List;

@Service
public class PaperService {

    @Autowired
    private PaperRepository paperRepository;

    public List<Paper> getAllPapers() {
        return paperRepository.findAll();
    }

    public Paper getPaperById(Long id) {
        return paperRepository.findById(id).orElse(null);
    }

    public Paper savePaper(Paper paper) {
        return paperRepository.save(paper);
    }

    public List<Paper> getPapersByStatus(String status) {
        return paperRepository.findByStatus(status);
    }
    
    public Paper getPaperByTitleAndAuthor(String title, String author) {
        return paperRepository.findByTitleAndAuthor(title, author);
    }

    /**
     * Changes the status of the paper to "reviewed".
     * 
     * @param paper The paper to be updated.
     */
    public void changePaperStatusToReviewed(Paper paper) {
        paper.setStatus("reviewed");
        paperRepository.save(paper);
    }
    
    public void updatePaperStatus(Long paperId, String status) {
        // Find the paper by ID
        Paper paper = paperRepository.findById(paperId)
                .orElseThrow(() -> new IllegalArgumentException("Paper not found with id: " + paperId));

        // Update the status
        paper.setStatus(status);

        // Save the updated paper
        paperRepository.save(paper);
    }
    
    @Transactional
    public void updatePaperStatusToReviewed(Long paperId) {
        // Find the paper by ID
        Paper paper = paperRepository.findById(paperId)
                .orElseThrow(() -> new IllegalArgumentException("Paper not found with id: " + paperId));

        // Update the status to "reviewed"
        paper.setStatus("reviewed");

        // Save the updated paper
        paperRepository.save(paper);
    }
}
