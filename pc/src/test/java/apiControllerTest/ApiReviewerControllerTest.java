package apiControllerTest;



import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import pc.ApiControllers.ApiReviewerController;
import pc.Model.Reviewer;
import pc.Service.ReviewersService;

@ExtendWith(MockitoExtension.class)
class ApiReviewerControllerTest {

    @Mock
    private ReviewersService reviewersService;

    @InjectMocks
    private ApiReviewerController controller;

    @Test
    void testGetAllReviewers_NoFilter() throws Exception {
        // Mock data
        Reviewer reviewer1 = new Reviewer();
        reviewer1.setId(1L);
        reviewer1.setName("John Doe");
        reviewer1.setExpertise("Computer Science"); // Set the expertise field correctly

        Reviewer reviewer2 = new Reviewer();
        reviewer2.setId(2L);
        reviewer2.setName("Jane Smith");
        reviewer2.setExpertise("Mathematics"); // Set the expertise field correctly

        List<Reviewer> reviewers = Arrays.asList(reviewer1, reviewer2);

        // Mock the service behavior
        when(reviewersService.getAllReviewers()).thenReturn(reviewers);

        // Set up MockMvc
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        // Perform GET request and verify the response
        mockMvc.perform(get("/api/reviewers")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.length()").value(reviewers.size()))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].name").value("John Doe"));
               // .andExpect(jsonPath("$[0].expertise").value("Computer Science"));
//                .andExpect(jsonPath("$[1].id").value(2))
//                .andExpect(jsonPath("$[1].name").value("Jane Smith"))
//                .andExpect(jsonPath("$[1].expertise").value("Mathematics"));
    }

    @Test
    void testGetAllReviewers_WithFilter() throws Exception {
        // Mock data
        Reviewer reviewer1 = new Reviewer();
        reviewer1.setId(1L);
        reviewer1.setName("John Doe");
        reviewer1.setExpertise("Computer Science");

        List<Reviewer> filteredReviewers = Arrays.asList(reviewer1);

        // Mock the service behavior
        when(reviewersService.getReviewersByExpertise("Computer Science")).thenReturn(filteredReviewers);

        // Set up MockMvc
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        // Perform GET request with expertise filter and verify the response
        mockMvc.perform(get("/api/reviewers?expertiseFilter=Computer Science")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.length()").value(filteredReviewers.size()))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].name").value("John Doe"));
                
    }
}