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
 * Controller class for handling requests related to accepted papers.
 */
@Controller
public class AcceptedPapersController {

    @Autowired
    private PaperService paperService;

    @Autowired
    private PaperRepository paperRepository;

    /**
     * Handles the GET request for "/acceptedpapers" endpoint.
     *
     * @return The view name for the accepted papers page.
     */
    @GetMapping("/acceptedpapers")
    public String getAllPapers(Model model) {
        // Retrieve all accepted papers from the database
        System.out.println("hello"); // corrected print statement

        List<Paper> acceptedPapers = paperService.getPapersByStatus("accepted");

        model.addAttribute("acceptedPapers", acceptedPapers);

        // Return the view name for the unreviewed papers page
        return "acceptedpapers";
    }
}
