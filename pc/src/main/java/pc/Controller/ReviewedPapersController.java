package pc.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.CrossOrigin; 
import org.springframework.web.bind.annotation.ResponseBody;

import pc.Model.Paper;
import pc.Service.PaperService;
import pc.Data.PaperRepository;

import java.util.List;
import java.util.Optional;

@Controller
public class ReviewedPapersController {

    @Autowired
    private PaperService paperService;

    @Autowired
    private PaperRepository paperRepository;

    @GetMapping("/reviewedpapers")
    public String getAllPapers(Model model) {
        List<Paper> reviewedPapers = paperService.getPapersByStatus("reviewed");
        model.addAttribute("reviewedPapers", reviewedPapers);
        return "reviewedpapers";
    }

    
}
