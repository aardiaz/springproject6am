package com.bway.springdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FacebookController {
	
	@GetMapping("/facebook")
	public String fbLogin() {
		
		return "redirect:https://www.facebook.com/dialog/oauth?client_id=510661802661055&redirect_uri=http://localhost/authorize/facebook&response_type=code&scope=email";
	}
	
	@GetMapping("/authorize/facebook")
	public String afterFbLogin() {
		
		return "redirect:/list";
	}

}
