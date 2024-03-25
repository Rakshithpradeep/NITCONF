package apiControllerTest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import pc.ApiControllers.ApiAcceptedController;
import pc.Model.Paper;
import pc.Service.PaperService;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import java.util.ArrayList;

@ExtendWith(MockitoExtension.class)
public class ApiAcceptedControllerTest {

    @Mock
    private PaperService paperService;

    @InjectMocks
    private ApiAcceptedController controller;

    @Test
    public void testGetAllAcceptedPapers() {
        // Arrange
        List<Paper> acceptedPapers = new ArrayList<>();
        // Assuming we have some accepted papers added to the list
        acceptedPapers.add(new Paper());
        acceptedPapers.add(new Paper());
        when(paperService.getPapersByStatus("accepted")).thenReturn(acceptedPapers);

        // Act
        List<Paper> result = controller.getAllAcceptedPapers();

        // Assert
        assertEquals(2, result.size()); // Assuming 2 accepted papers are returned
    }
}