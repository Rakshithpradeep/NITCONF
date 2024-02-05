package pc.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller class for handling logout-related requests.
 */
@Controller
@RequestMapping("/")
public class LogoutController {

    /**
     * Handles the GET request for "/logout" endpoint.
     *
     * @return The view name for the login page.
     */
    @GetMapping("/logout")
    public String logout() {
        return "login";
    }
}
