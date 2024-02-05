package pc.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller class for handling requests related to user profiles.
 */
@Controller
public class ProfileController {

    /**
     * Handles the GET request for "/profile" endpoint.
     *
     * @return The view name for the profile page.
     */
    @GetMapping("/profile")
    public String profile() {
        return "profile";
    }
}

