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
        List<Reviewer> reviewers = new ArrayList<>();
        reviewers.add(new Reviewer());
        reviewers.add(new Reviewer());
        String expertise = "Computer Science";
        
        when(reviewerRepository.findByExpertise(expertise)).thenReturn(reviewers);

        List<Reviewer> result = reviewersService.getReviewersByExpertise(expertise);

        assertEquals(reviewers, result);
    }

}