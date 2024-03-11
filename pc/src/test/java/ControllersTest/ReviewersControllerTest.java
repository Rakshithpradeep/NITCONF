package ControllersTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import pc.Model.Reviewer;
import pc.Service.ReviewersService;
import pc.Controller.ReviewersController;

public class ReviewersControllerTest {

    @Mock
    private ReviewersService reviewersService;

    @InjectMocks
    private ReviewersController reviewersController;

    @Mock
    private Model model;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllReviewers() {
        List<Reviewer> reviewers = new ArrayList<>();
        reviewers.add(new Reviewer());
        reviewers.add(new Reviewer());

        when(reviewersService.getAllReviewers()).thenReturn(reviewers);

        String viewName = reviewersController.getAllReviewers(null, model);

        assertEquals("reviewers", viewName);
        verify(model).addAttribute(eq("reviewersList"), eq(reviewers));
    }

    @Test
    public void testGetReviewersByExpertise() {
        List<Reviewer> reviewers = new ArrayList<>();
        reviewers.add(new Reviewer());
        reviewers.add(new Reviewer());

        when(reviewersService.getReviewersByExpertise("expertise")).thenReturn(reviewers);

        String viewName = reviewersController.getAllReviewers("expertise", model);

        assertEquals("reviewers", viewName);
        verify(model).addAttribute(eq("reviewersList"), eq(reviewers));
    }
}
