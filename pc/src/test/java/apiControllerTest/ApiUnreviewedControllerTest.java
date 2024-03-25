package apiControllerTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import pc.Model.Paper;
import pc.Model.Reviewer;
import pc.Service.PaperService;
import pc.Service.ReviewersService;
import pc.ApiControllers.ApiUnreviewedController;
import pc.Data.PaperRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ApiUnreviewedControllerTest {

    @Mock
    private PaperService paperService;

    @Mock
    private PaperRepository paperRepository;

    @Mock
    private ReviewersService reviewersService;

    @InjectMocks
    private ApiUnreviewedController controller;

    @Test
    public void testGetAllUnreviewedPapers() {
        // Arrange
        List<Paper> unreviewedPapers = new ArrayList<>();
        // Add some sample unreviewed papers to the list
        unreviewedPapers.add(new Paper());
        unreviewedPapers.add(new Paper());
        when(paperService.getPapersByStatus("unreviewed")).thenReturn(unreviewedPapers);

        // Act
        ResponseEntity<List<Paper>> responseEntity = controller.getAllUnreviewedPapers();

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(unreviewedPapers, responseEntity.getBody());
    }

    @Test
    public void testGetAllReviewers() {
        // Arrange
        List<Reviewer> reviewersList = new ArrayList<>();
        // Add some sample reviewers to the list
        reviewersList.add(new Reviewer());
        reviewersList.add(new Reviewer());
        when(reviewersService.getAllReviewers()).thenReturn(reviewersList);

        // Act
        ResponseEntity<List<Reviewer>> responseEntity = controller.getAllReviewers();

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(reviewersList, responseEntity.getBody());
    }

    @Test
    public void testMarkPaperAsReviewed_ExistingPaper() {
        // Arrange
        Long paperId = 1L;
        Paper paper = new Paper();
        paper.setId(paperId);
        paper.setStatus("unreviewed");
        when(paperRepository.findById(paperId)).thenReturn(Optional.of(paper));

        // Act
        ResponseEntity<String> responseEntity = controller.markPaperAsReviewed(paperId);

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Paper with ID " + paperId + " marked as reviewed.", responseEntity.getBody());
        assertEquals("reviewed", paper.getStatus());
        verify(paperRepository, times(1)).save(paper);
    }


}