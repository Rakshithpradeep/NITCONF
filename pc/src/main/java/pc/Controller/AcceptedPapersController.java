package pc.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller class for handling requests related to accepted papers.
 */
@Controller
public class AcceptedPapersController {

    /**
     * Handles the GET request for "/acceptedpapers" endpoint.
     *
     * @return The view name for the accepted papers page.
     */
    @GetMapping("/acceptedpapers")
    public String acceptedpapers() {
        return "acceptedpapers";
    }
}
