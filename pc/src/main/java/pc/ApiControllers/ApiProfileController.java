package pc.ApiControllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import pc.Model.Reviewer;
import pc.Model.User;
import pc.Service.UserService;

/**
 * Controller class for handling requests related to user profiles.
 */
@RestController
public class ApiProfileController {

    private final UserService userService;

    public ApiProfileController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Handles the GET request for "/profile" endpoint.
     *
     * @return The view name for the profile page.
     */
    @GetMapping("/api/profile")
    public  ResponseEntity<List<User>>  showProfilePage(Model model) {
        // Fetch the current user details from the database
        User currentUser = userService.getCurrentUser();

        // Pass the user object to the Thymeleaf template
        model.addAttribute("user", currentUser);
        
        // Return the view name for the profile page
        //return "profile";
        return new ResponseEntity<>( HttpStatus.OK);
    }
}
