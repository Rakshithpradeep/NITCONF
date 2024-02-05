package pc.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller class for handling requests related to rejected papers.
 */
@Controller
public class RejectedPapersController {

    /**
     * Handles the GET request for "/rejectedpapers" endpoint.
     *
     * @return The view name for the rejected papers page.
     */
    @GetMapping("/rejectedpapers")
    public String rejectedpapers() {
        return "rejectedpapers";
    }
}
