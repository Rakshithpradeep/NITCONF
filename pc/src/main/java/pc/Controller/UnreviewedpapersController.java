package pc.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UnreviewedpapersController {
	
@GetMapping("/unreviewedpapers")	
public String unreviewedpapers() {
	return "unreviewedpapers";
	
}
}
