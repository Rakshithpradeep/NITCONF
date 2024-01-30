package pc.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AcceptedPapersController {
	
@GetMapping("/acceptedpapers")	
public String acceptedpapers() {
	return "acceptedpapers";
}
}
