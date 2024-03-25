package ControllersTest;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import pc.Model.Paper;
import pc.Model.Reviewer;
import pc.Service.PaperService;
import pc.Service.ReviewersService;
import pc.Controller.UnReviewedPapersController;
import pc.Data.PaperRepository;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UnReviewedPapersControllerTest {

    @InjectMocks
    private UnReviewedPapersController controller;

    @Mock
    private PaperService paperService;

    @Mock
    private ReviewersService reviewersService;

    @Mock
    private PaperRepository paperRepository;

    @Mock
    private Model model;

    @Test
    void testGetAllPapers() {
        // Mock data
        List<Paper> unreviewedPapers = new ArrayList<>();
        unreviewedPapers.add(new Paper());
        unreviewedPapers.add(new Paper());

        List<Reviewer> reviewersList = new ArrayList<>();
        reviewersList.add(new Reviewer());
        reviewersList.add(new Reviewer());

        // Mock behavior
        when(paperService.getPapersByStatus("unreviewed")).thenReturn(unreviewedPapers);
        when(reviewersService.getAllReviewers()).thenReturn(reviewersList);

        // Test
        String viewName = controller.getAllPapers(model);

        // Verify behavior
        verify(paperService, times(1)).getPapersByStatus("unreviewed");
        verify(reviewersService, times(1)).getAllReviewers();
        verify(model, times(1)).addAttribute("unreviewedPapers", unreviewedPapers);
        verify(model, times(1)).addAttribute("reviewersList", reviewersList);

        // Asserts
        assertEquals("unreviewedpapers", viewName);
    }

    @Test
    void testMarkPaperAsReviewed() {
        // Mock data
        Long paperId = 1L;
        Paper paper = new Paper();
        paper.setStatus("unreviewed");

        // Mock behavior
        when(paperRepository.findById(paperId)).thenReturn(java.util.Optional.of(paper));

        // Test
        ResponseEntity<String> responseEntity = controller.markPaperAsReviewed(paperId);

        // Verify behavior
        verify(paperRepository, times(1)).findById(paperId);
        verify(paperRepository, times(1)).save(paper);

        // Asserts
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Paper with ID 1 marked as reviewed.", responseEntity.getBody());
        assertEquals("reviewed", paper.getStatus());
    }

    @Test
    void testMarkPaperAsReviewedNotFound() {
        // Mock data
        Long paperId = 1L;

        // Mock behavior
        when(paperRepository.findById(paperId)).thenReturn(java.util.Optional.empty());

        // Test
        ResponseEntity<String> responseEntity = controller.markPaperAsReviewed(paperId);

        // Verify behavior
        verify(paperRepository, times(1)).findById(paperId);
        verify(paperRepository, never()).save(any());

        // Asserts
        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
        assertEquals("Paper not found with ID: 1", responseEntity.getBody());
    }
}