package apiControllerTest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import pc.Model.Paper;
import pc.Service.PaperService;
import pc.ApiControllers.ApiReviewedController;
import pc.Data.PaperRepository;

import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ApiReviewedControllerTest {

    @Mock
    private PaperService paperService;

    @Mock
    private PaperRepository paperRepository;

    @InjectMocks
    private ApiReviewedController controller;

    @Test
    public void testGetAllReviewedPapers() {
        // Arrange
        // Mocking the service to return a list of reviewed papers
        when(paperService.getPapersByStatus("reviewed")).thenReturn(List.of(new Paper(), new Paper()));

        // Act
        ResponseEntity<?> responseEntity = controller.getAllReviewedPapers();

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(2, ((List<?>) responseEntity.getBody()).size()); // Assuming 2 reviewed papers are returned
    }

    @Test
    public void testUpdatePaperStatus_AcceptDecision() {
        // Arrange
        Long paperId = 1L;
        Paper paper = new Paper();
        paper.setId(paperId);
        paper.setStatus("reviewed");
        when(paperRepository.findById(paperId)).thenReturn(Optional.of(paper));

        // Act
        ResponseEntity<String> responseEntity = controller.updatePaperStatus(paperId, "accept");

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("accepted", paper.getStatus()); // Asserting that the status is updated to 'accepted'
        verify(paperRepository, times(1)).save(paper);
    }

    @Test
    public void testUpdatePaperStatus_RejectDecision() {
        // Arrange
        Long paperId = 1L;
        Paper paper = new Paper();
        paper.setId(paperId);
        paper.setStatus("reviewed");
        when(paperRepository.findById(paperId)).thenReturn(Optional.of(paper));

        // Act
        ResponseEntity<String> responseEntity = controller.updatePaperStatus(paperId, "reject");

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("rejected", paper.getStatus()); // Asserting that the status is updated to 'rejected'
        verify(paperRepository, times(1)).save(paper);
    }

    @Test
    public void testUpdatePaperStatus_PaperNotFound() {
        // Arrange
        Long paperId = 1L;
        when(paperRepository.findById(paperId)).thenReturn(Optional.empty());

        // Act
        ResponseEntity<String> responseEntity = controller.updatePaperStatus(paperId, "accept");

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
        assertEquals("Paper not found", responseEntity.getBody());
        verify(paperRepository, never()).save(any());
    }
}