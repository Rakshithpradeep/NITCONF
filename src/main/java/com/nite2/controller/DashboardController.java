package com.nite2.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.nite2.data.UserRepository;
import com.nite2.model.User;

import jakarta.servlet.http.HttpSession;



@Controller
@RequestMapping("/dashboard")
@SessionAttributes(("user"))
public class DashboardController {

	
	@Autowired
	private UserRepository userRepository;
	
	
	@ModelAttribute("user")
	public User user()
	{
		return new User();
	}

	
	
	@GetMapping
	public String dashboard(Principal principal,Model model,HttpSession session)
	{
		
		User user = userRepository.findById(userRepository.findUserByUsername(principal.getName()).getUsername()).get();
		model.addAttribute("user", user);
		System.out.println(user.toString());
		return "dashboard";
	}
	
}