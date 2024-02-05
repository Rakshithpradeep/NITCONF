package pc.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller class for handling requests related to reviewed papers.
 */
@Controller
public class ReviewedPapersController {

    /**
     * Handles the GET request for "/reviewedpapers" endpoint.
     *
     * @return The view name for the reviewed papers page.
     */
    @GetMapping("/reviewedpapers")
    public String reviewedpapers() {
        return "reviewedpapers";
    }
}
