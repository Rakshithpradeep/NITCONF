package pc.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RejectedPapersController {
	
@GetMapping("/rejectedpapers")	
public String rejectedpapers() {
	return "rejectedpapers";
}
}
