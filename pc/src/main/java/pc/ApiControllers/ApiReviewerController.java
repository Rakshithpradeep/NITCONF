package pc.ApiControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pc.Model.Reviewer;
import pc.Service.ReviewersService;

/**
 * Controller class for handling requests related to reviewers.
 */
@RestController
public class ApiReviewerController {

    @Autowired
    private ReviewersService reviewersService;

    /**
     * Handles the GET request for "/reviewers" endpoint to retrieve all reviewers.
     *
     * @param model The Spring MVC model.
     * @return The view name for the reviewers page.
     */
    @GetMapping("/api/reviewers")
    public  ResponseEntity<List<Reviewer>> getAllReviewers(@RequestParam(required = false) String expertiseFilter) {
    	 List<Reviewer> reviewersList;

    	    if (expertiseFilter != null && !expertiseFilter.isEmpty()) {
    	        // If expertiseFilter is provided, filter reviewers by expertise
    	        reviewersList = reviewersService.getReviewersByExpertise(expertiseFilter);
    	    } else {
    	        // Otherwise, get all reviewers
    	        reviewersList = reviewersService.getAllReviewers();
    	    }
        // Add the list of reviewers to the model
        //model.addAttribute("reviewersList", reviewersList);

        // Return the view name for the reviewers page
       // return "reviewers";
        return new ResponseEntity<>(reviewersList, HttpStatus.OK);
    }
}




