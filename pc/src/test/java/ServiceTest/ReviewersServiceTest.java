package ServiceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import pc.Data.ReviewersRepository;
import pc.Model.Reviewer;
import pc.Service.ReviewersService;

public class ReviewersServiceTest {

    @Mock
    private ReviewersRepository reviewerRepository;

    @InjectMocks
    private ReviewersService reviewersService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllReviewers() {
        List<Reviewer> reviewers = new ArrayList<>();
        reviewers.add(new Reviewer());
        reviewers.add(new Reviewer());

        when(reviewerRepository.findAll()).thenReturn(reviewers);

        List<Reviewer> result = reviewersService.getAllReviewers();

        assertEquals(reviewers, result);
    }

    @Test
    public void testGetReviewersByExpertise() {
        // arrange-Creating the mock data
        List<Reviewer> reviewers = new ArrayList<>();
        Reviewer reviewer1 = new Reviewer();
        reviewer1.setExpertise("Computer Science");
        Reviewer reviewer2 = new Reviewer();
        reviewer2.setExpertise("Computer Science");
        reviewers.add(reviewer1);
        reviewers.add(reviewer2);
        String expertise = "Computer Science";
        
        // act-Mock repository behavior
        when(reviewerRepository.findByExpertise(expertise)).thenReturn(reviewers);

        // Call the service method
        List<Reviewer> result = reviewersService.getReviewersByExpertise(expertise);

        // Verify the result
        assertEquals(reviewers.size(), result.size());
        for (int i = 0; i < reviewers.size(); i++) {
            assertEquals(reviewers.get(i), result.get(i));
        }
    }

}