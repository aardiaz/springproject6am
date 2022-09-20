package com.bway.springdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bway.springdemo.model.User;
import com.bway.springdemo.repository.UserRepository;

@Controller
public class SignupController {
	
	@Autowired
	private UserRepository userRepo;
	
	@GetMapping("/signup")
	public String showSignup() {

		return "SignupForm";
	}
	
	@PostMapping("/signup")
	public String saveUser(@ModelAttribute User user) {
		
		user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
		userRepo.save(user);
		
		return "LoginForm";
	}

}
