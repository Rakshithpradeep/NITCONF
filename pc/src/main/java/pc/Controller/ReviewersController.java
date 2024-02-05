package pc.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import pc.Model.Reviewer;
import pc.Service.ReviewersService;

/**
 * Controller class for handling requests related to reviewers.
 */
@Controller
public class ReviewersController {

    @Autowired
    private ReviewersService reviewersService;

    /**
     * Handles the GET request for "/reviewers" endpoint to retrieve all reviewers.
     *
     * @param model The Spring MVC model.
     * @return The view name for the reviewers page.
     */
    @GetMapping("/reviewers")
    public String getAllReviewers(Model model) {
        // Retrieve the list of reviewers from the service
        List<Reviewer> reviewersList = reviewersService.getAllReviewers();

        // Add the list of reviewers to the model
        model.addAttribute("reviewersList", reviewersList);

        // Return the view name for the reviewers page
        return "reviewers";
    }
}

/*
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pc.Model.Reviewer;
import pc.Service.ReviewersService;

import java.util.List;

@RestController
@RequestMapping("/reviewers")
public class ReviewersController {
    @Autowired
    private ReviewersService reviewerService;

    @GetMapping
    public List<Reviewer> getAllReviewers() {
        return reviewerService.getAllReviewers();
    }
}*/



