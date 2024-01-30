package pc.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReviewersController {
	
@GetMapping("/reviewers")	
public String reviewers() {
	return "reviewers";
}
}
