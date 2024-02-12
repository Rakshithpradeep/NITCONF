package pc.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pc.Model.User;
import pc.Service.UserService;

/**
 * Controller class for handling requests related to user profiles.
 */
@Controller
public class ProfileController {

    private final UserService userService;

    public ProfileController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Handles the GET request for "/profile" endpoint.
     *
     * @return The view name for the profile page.
     */
    @GetMapping("/profile")
    public String showProfilePage(Model model) {
        // Fetch the current user details from the database
        User currentUser = userService.getCurrentUser();

        // Pass the user object to the Thymeleaf template
        model.addAttribute("user", currentUser);
        
        // Return the view name for the profile page
        return "profile";
    }
}
