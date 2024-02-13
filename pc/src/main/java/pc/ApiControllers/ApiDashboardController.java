package pc.ApiControllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pc.Data.UserRepository;
import pc.Model.User;

@RestController
@RequestMapping("/api/dashboard")
public class ApiDashboardController {

    private static final User NULL = null;
	@Autowired
    private UserRepository userRepository;

    @GetMapping
    public User dashboard(Principal principal) {
        // Retrieve user information from the repository based on the authenticated principal
        User user = userRepository.findUserByUsername(principal.getName());

        if (user != null) {
            // Optionally, you might want to remove sensitive information before returning
            user.setPassword(null); // Assuming User has a setPassword method

            // Return the user object directly as the response body
            return user;
        } else {
            // If user not found, you can return appropriate response, e.g., 404 Not Found
            return NULL;
        }
    }
}
