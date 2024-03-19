package pc.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import pc.Data.PaperRepository;
import pc.Model.Paper;
import pc.Service.PaperService;

/**
 * Controller class for handling requests related to rejected papers.
 */
@Controller
public class RejectedPapersController {
    
    @Autowired
    private PaperService paperService;
    
    @Autowired
    private PaperRepository paperRepository;

    /**
     * Handles the GET request for "/rejectedpapers" endpoint.
     *
     * @return The view name for the rejected papers page.
     */
    @GetMapping("/rejectedpapers")
    public String getAllPapers(Model model) {
        // Retrieve all accepted papers from the database
        System.out.println("hello");
        List<Paper> rejectedPapers = paperService.getPapersByStatus("rejected");

        model.addAttribute("rejectedPapers", rejectedPapers);

        // Return the view name for the unreviewed papers page
        return "rejectedpapers";
    }
}
