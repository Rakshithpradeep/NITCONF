package pc.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller class for handling requests related to discussions.
 */
@Controller
public class DiscussionsController {

    /**
     * Handles the GET request for "/discussions" endpoint.
     *
     * @return The view name for the discussions page.
     */
    @GetMapping("/discussions")
    public String discussion() {
        return "discussions";
    }
}
