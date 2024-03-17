package ServiceTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import pc.Data.ReviewersRepository;
import pc.Model.Reviewer;
import pc.Service.ReviewersService;

public class ReviewersServiceTest {

    // Mock object for ReviewersRepository
    @Mock
    private ReviewersRepository reviewersRepositoryMock;

    // Injecting mocks into ReviewersService
    @InjectMocks
    private ReviewersService reviewersService;

    // Initialization method to set up mock objects
    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this); // Initialize mocks
    }

    // Test method to verify fetching all reviewers
    @Test
    public void testGetAllReviewers() {
        // Arrange
        List<Reviewer> expectedReviewers = new ArrayList<>();
        expectedReviewers.add(createReviewer(1L, "John Doe", "john@example.com", "Expert A", "1234567890", "5"));
        expectedReviewers.add(createReviewer(2L, "Jane Smith", "jane@example.com", "Expert B", "9876543210", "3"));
        when(reviewersRepositoryMock.findAll()).thenReturn(expectedReviewers); // Stubbing repository method

        // Act
        List<Reviewer> actualReviewers = reviewersService.getAllReviewers();

        // Assert
        assertEquals(expectedReviewers.size(), actualReviewers.size());
        for (int i = 0; i < expectedReviewers.size(); i++) {
            assertEquals(expectedReviewers.get(i), actualReviewers.get(i));
        }
    }

    // Test method to verify fetching reviewers by expertise
    @Test
    public void testGetReviewersByExpertise() {
        // Arrange
        String expertise = "Expert A";
        List<Reviewer> expectedReviewers = new ArrayList<>();
        expectedReviewers.add(createReviewer(1L, "John Doe", "john@example.com", expertise, "1234567890", "5"));
        expectedReviewers.add(createReviewer(1L, "John rao", "johnrao@example.com", expertise, "1234567890", "2"));
        when(reviewersRepositoryMock.findByExpertise(expertise)).thenReturn(expectedReviewers); // Stubbing repository method

        // Act
        List<Reviewer> actualReviewers = reviewersService.getReviewersByExpertise(expertise);

        // Assert
        assertEquals(expectedReviewers.size(), actualReviewers.size());
        for (int i = 0; i < expectedReviewers.size(); i++) {
            assertEquals(expectedReviewers.get(i), actualReviewers.get(i));
        }
    }
    
    // Test method to verify fetching reviewers by invalid expertise
    @Test
    public void testGetReviewersByInvalidExpertise() {
        // Arrange
        String invalidExpertise = "Invalid Expertise";
        when(reviewersRepositoryMock.findByExpertise(invalidExpertise)).thenReturn(new ArrayList<>()); // Stubbing repository method

        // Act
        List<Reviewer> actualReviewers = reviewersService.getReviewersByExpertise(invalidExpertise);

        // Assert
        assertEquals(0, actualReviewers.size());
    }

    // Helper method to create Reviewer objects
    private Reviewer createReviewer(Long id, String name, String email, String expertise, String mobile, String papersCount) {
        Reviewer reviewer = new Reviewer();
        reviewer.setId(id);
        reviewer.setName(name);
        reviewer.setEmail(email);
        reviewer.setExpertise(expertise);
        reviewer.setMobile(mobile);
        reviewer.setPapersCount(papersCount);
        return reviewer;
    }
}
