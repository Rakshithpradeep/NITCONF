package pc.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pc.Data.ReviewersRepository;
import pc.Model.Reviewer;

import java.util.List;

/**
 * Service class for managing Reviewer entities.
 */
@Service
public class ReviewersService {

    @Autowired
    private ReviewersRepository reviewerRepository;

    /**
     * Retrieves a list of all reviewers.
     *
     * @return The list of all reviewers.
     */
    public List<Reviewer> getAllReviewers() {
        return reviewerRepository.findAll();
    }
    public List<Reviewer> getReviewersByExpertise(String expertise) {
        return reviewerRepository.findByExpertise(expertise);
    }

}
