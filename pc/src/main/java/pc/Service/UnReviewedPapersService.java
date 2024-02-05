package pc.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnreviewedPaperService {
    private final UnreviewedPaperRepository unreviewedPaperRepository;

    @Autowired
    public UnreviewedPaperService(UnreviewedPaperRepository unreviewedPaperRepository) {
        this.unreviewedPaperRepository = unreviewedPaperRepository;
    }

    public List<UnreviewedPaper> getAllUnreviewedPapers() {
        return unreviewedPaperRepository.findAll();
    }

    // Add more service methods as needed

    // Example of adding a method to save an unreviewed paper
    public UnreviewedPaper saveUnreviewedPaper(UnreviewedPaper unreviewedPaper) {
        return unreviewedPaperRepository.save(unreviewedPaper);
    }
}

