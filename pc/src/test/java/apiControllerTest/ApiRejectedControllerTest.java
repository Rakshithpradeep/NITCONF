package apiControllerTest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import pc.ApiControllers.ApiRejectedController;
import pc.Model.Paper;
import pc.Service.PaperService;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import java.util.ArrayList;

@ExtendWith(MockitoExtension.class)
public class ApiRejectedControllerTest {

    @Mock
    private PaperService paperService;

    @InjectMocks
    private ApiRejectedController controller;

    @Test
    public void testGetAllRejectedPapers() {
        // Arrange
        List<Paper> rejectedPapers = new ArrayList<>();
        // Assuming we have some rejected papers added to the list
        rejectedPapers.add(new Paper());
        rejectedPapers.add(new Paper());
        when(paperService.getPapersByStatus("rejected")).thenReturn(rejectedPapers);

        // Act
        List<Paper> result = controller.getAllRejectedPapers();

        // Assert
        assertEquals(2, result.size()); // Assuming 2 rejected papers are returned
    }
}