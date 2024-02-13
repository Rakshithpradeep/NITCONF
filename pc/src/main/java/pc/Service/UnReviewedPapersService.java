package pc.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pc.Data.UnReviewedPapersRepository;
import pc.Model.UnReviewedPapers;

import java.util.List;
import java.util.Optional;

@Service
public class UnReviewedPapersService {

    @Autowired
    private UnReviewedPapersRepository paperRepository;

    public List<UnReviewedPapers> getAllPapers() {
        return paperRepository.findAll();
    }

    public Optional<UnReviewedPapers> getPaperById(Long id) {
        return paperRepository.findById(id);
    }

    public UnReviewedPapers createPaper(UnReviewedPapers paper) {
        return paperRepository.save(paper);
    }

    public Optional<UnReviewedPapers> updatePaper(Long id, UnReviewedPapers paper) {
        if (!paperRepository.existsById(id)) {
            return Optional.empty();
        }
        paper.setId(id);
        return Optional.of(paperRepository.save(paper));
    }

    public boolean deletePaper(Long id) {
        if (!paperRepository.existsById(id)) {
            return false;
        }
        paperRepository.deleteById(id);
        return true;
    }
}

