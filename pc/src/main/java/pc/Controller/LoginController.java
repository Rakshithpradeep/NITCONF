package pc.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/")
public class LoginController {
	


	@GetMapping("/login")
	public String login()
	{
		return "login";
	}

	 
	@PostMapping("/login")            
	public String loginForm()
	{ 
		
    	return "redirect:/dashboard";
		
	}
}
