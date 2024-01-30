package pc.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReviewedPapersController {
	
@GetMapping("/reviewedpapers")	
public String reviewedpapers() {
	return "reviewedpapers";
}
}
