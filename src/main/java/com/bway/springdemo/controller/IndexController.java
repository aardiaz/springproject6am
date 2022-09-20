package com.bway.springdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
//controller is use to processing httpRequests.
public class IndexController {
	
	@GetMapping("/")
	public String indexPage() {
		
		return "LoginForm";
	}

}
