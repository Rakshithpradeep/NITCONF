package pc.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class AcceptedPapersController {
	
@GetMapping("/acceptedpapers")	
public String acceptedpapers() {
	return "acceptedpapers";
}
}
