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

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public User getDashboardInfo(Principal principal) {
        // Retrieve user information from the repository based on the authenticated principal
        String username = principal.getName();
        User user = userRepository.findUserByUsername(username);
        
        // You may want to handle cases where user is not found
        if (user == null) {
            throw new RuntimeException("User not found");
        }

        // Return user object directly, which will be converted to JSON response
        return user;
    }
}