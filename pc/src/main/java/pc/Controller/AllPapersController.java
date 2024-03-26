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
public class AllPapersController {

    @Autowired
    private PaperService paperService;

    @Autowired
    private PaperRepository paperRepository;

    /**
   
     *
     *
     */
    @GetMapping("/allpapers")
    public String getAllPapers(Model model) {
        // Retrieve all accepted papers from the database
        System.out.println("hello"); // corrected print statement

        List<Paper> allPapers = paperService.getAllPapers();

        model.addAttribute("allPapers", allPapers);

        // Return the view name for the unreviewed papers page
        return "allpapers";
    }
}
