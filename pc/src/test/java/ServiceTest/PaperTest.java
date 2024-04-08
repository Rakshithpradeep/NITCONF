package ServiceTest;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import pc.Data.PaperRepository;
import pc.Model.Paper;
import pc.Service.PaperService;

public class PaperTest {

    @Mock
    private PaperRepository paperRepositoryMock;

    @InjectMocks
    private PaperService paperService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllPapers() {
        // Create a list of mock papers
        List<Paper> expectedPapers = new ArrayList<>();
        expectedPapers.add(new Paper());
        expectedPapers.add(new Paper());

        // Mock the behavior of paperRepository.findAll()
        when(paperRepositoryMock.findAll()).thenReturn(expectedPapers);

        // Call the method under test
        List<Paper> actualPapers = paperService.getAllPapers();

        // Verify the result
        assertEquals(expectedPapers.size(), actualPapers.size());
    }

    @Test
    public void testGetPaperById() {
        // Create a mock paper
        Paper expectedPaper = new Paper();
        expectedPaper.setId(1L);

        // Mock the behavior of paperRepository.findById()
        when(paperRepositoryMock.findById(1L)).thenReturn(Optional.of(expectedPaper));

        // Call the method under test
        Paper actualPaper = paperService.getPaperById(1L);

        // Verify the result
        assertEquals(expectedPaper, actualPaper);
    }

   

    @Test
    public void testGetPapersByStatus() {
        // Create a list of mock papers
        List<Paper> expectedPapers = new ArrayList<>();
        expectedPapers.add(new Paper());
        expectedPapers.add(new Paper());

        // Mock the behavior of paperRepository.findByStatus()
        when(paperRepositoryMock.findByStatus("pending")).thenReturn(expectedPapers);

        // Call the method under test
        List<Paper> actualPapers = paperService.getPapersByStatus("pending");

        // Verify the result
        assertEquals(expectedPapers.size(), actualPapers.size());
    }

}