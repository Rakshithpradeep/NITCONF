package ControllersTest;

// Import necessary dependencies
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

// Define a test class named ReviewersControllerTest
public class ReviewersControllerTest {

    // Mock ReviewersService to simulate its behavior
    @Mock
    private ReviewersService reviewersService;

    // Inject mocked ReviewersService into ReviewersController
    @InjectMocks
    private ReviewersController reviewersController;

    // Mock Model to simulate model behavior
    @Mock
    private Model model;

    // Method to initialize mocks before each test method
    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    // Test method to verify the behavior of getAllReviewers() method in ReviewersController
    @Test
    public void testGetAllReviewers() {
        // Call getAllReviewers() method in ReviewersController with null expertise and mocked model
        String viewName = reviewersController.getAllReviewers(null, model);
        // Assert that the returned view name is "reviewers"
        assertEquals("reviewers", viewName);
    }

    // Test method to verify the behavior of getAllReviewers() method with expertise parameter in ReviewersController
    @Test
    public void testGetReviewersByExpertise() {
        // Call getAllReviewers() method in ReviewersController with "expertise" parameter and mocked model
        String viewName = reviewersController.getAllReviewers("expertise", model);
        // Assert that the returned view name is "reviewers"
        assertEquals("reviewers", viewName);
    }
}
