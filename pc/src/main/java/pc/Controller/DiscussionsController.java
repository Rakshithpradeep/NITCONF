package pc.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DiscussionsController {
	@GetMapping("/discussions")
public String discussion() {
	return "discussions";
}
}
