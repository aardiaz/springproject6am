package com.bway.springdemo.controller;

import java.io.File;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GalleryController {
	
	@GetMapping("/gallery")
	public String showGallery(Model model, HttpSession session) {
		
		if(session.getAttribute("activeUser") == null) {
			
			return "LoginForm";
		}
		
		
	String[]  imgNames	= new File("src/main/resources/static/images").list();
	model.addAttribute("imgList",imgNames);
		
		return "Gallery";
	}

}
