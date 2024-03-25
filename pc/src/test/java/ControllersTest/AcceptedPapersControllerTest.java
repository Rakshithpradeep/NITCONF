package ControllersTest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

import pc.Controller.AcceptedPapersController;
import pc.Data.PaperRepository;
import pc.Model.Paper;
import pc.Service.PaperService;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AcceptedPapersControllerTest {

    @InjectMocks
    private AcceptedPapersController controller;

    @Mock
    private PaperService paperService;

    @Mock
    private PaperRepository paperRepository;

    @Mock
    private Model model;

    @Test
    void testGetAllPapers() {
        // Mock data
        List<Paper> acceptedPapers = new ArrayList<>();
        acceptedPapers.add(new Paper());
        acceptedPapers.add(new Paper());

        // Mock behavior
        when(paperService.getPapersByStatus("accepted")).thenReturn(acceptedPapers);

        // Test
        String viewName = controller.getAllPapers(model);

        // Verify behavior
        verify(paperService, times(1)).getPapersByStatus("accepted");
        verify(model, times(1)).addAttribute("acceptedPapers", acceptedPapers);

        // Asserts
        assertEquals("acceptedpapers", viewName);
    }

    @Test
    void testGetAllPapersNoAcceptedPapers() {
        // Mock data
        List<Paper> acceptedPapers = new ArrayList<>();

        // Mock behavior
        when(paperService.getPapersByStatus("accepted")).thenReturn(acceptedPapers);

        // Test
        String viewName = controller.getAllPapers(model);

        // Verify behavior
        verify(paperService, times(1)).getPapersByStatus("accepted");
        verify(model, times(1)).addAttribute("acceptedPapers", acceptedPapers);

        // Asserts
        assertEquals("acceptedpapers", viewName);
    }
}
