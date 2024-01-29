package pc.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class LoginController {
	
	
	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(LoginController.class);

	@GetMapping("/login")
	public String login()
	{
		return "login";
	}

	 
	@PostMapping("/login")            
	public String loginForm()
	{ 
		
		return "redirect:/dasboard";
		
	}
}
