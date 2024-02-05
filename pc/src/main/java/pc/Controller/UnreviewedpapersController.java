package pc.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller class for handling requests related to unreviewed papers.
 */
@Controller
public class UnreviewedpapersController {

    /**
     * Handles the GET request for "/unreviewedpapers" endpoint.
     *
     * @return The view name for the unreviewed papers page.
     */
    @GetMapping("/unreviewedpapers")
    public String unreviewedpapers() {
        return "unreviewedpapers";
    }
}
