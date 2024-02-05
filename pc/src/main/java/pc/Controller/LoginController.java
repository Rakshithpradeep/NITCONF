package pc.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller class for handling login-related requests.
 */
@Controller
@RequestMapping("/")
public class LoginController {

    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(LoginController.class);

    /**
     * Handles the GET request for "/login" endpoint.
     *
     * @return The view name for the login page.
     */
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    /**
     * Handles the POST request for "/login" endpoint.
     *
     * @return Redirects to the "/dashboard" endpoint.
     */
    @PostMapping("/login")
    public String loginForm() {
        return "redirect:/dashboard";
    }
}
