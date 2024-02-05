package pc.Controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.servlet.http.HttpSession;
import pc.Data.UserRepository;
import pc.Model.User;

/**
 * Controller class for handling requests related to the dashboard.
 */
@Controller
@RequestMapping("/dashboard")
@SessionAttributes(("user"))
public class DashboardController {

    @Autowired
    private UserRepository userRepository;

    /**
     * Provides a default User object as a model attribute.
     *
     * @return A new User object.
     */
    @ModelAttribute("user")
    public User user() {
        return new User();
    }

    /**
     * Handles the GET request for the "/dashboard" endpoint.
     *
     * @param principal The authenticated user principal.
     * @param model     The Spring MVC model.
     * @param session   The HTTP session.
     * @return The view name for the dashboard page.
     */
    @GetMapping
    public String dashboard(Principal principal, Model model, HttpSession session) {

        // Retrieve user information from the repository based on the authenticated principal
        User user = userRepository.findById(userRepository.findUserByUsername(principal.getName()).getUsername()).get();

        // Add the user object to the model
        model.addAttribute("user", user);

        // Print user information to the console for debugging purposes
        System.out.println(user.toString());

        // Return the view name for the dashboard page
        return "dashboard";
    }
}
