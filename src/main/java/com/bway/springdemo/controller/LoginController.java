package com.bway.springdemo.controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bway.springdemo.model.User;
import com.bway.springdemo.repository.UserRepository;
import com.bway.springdemo.utils.VerifyRecaptcha;

@Controller
public class LoginController {
	
	private static final Logger  log = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private UserRepository userRepo;

	@GetMapping("/login")
	public String showLogin() {

		
		return "LoginForm";
	}

	@PostMapping("/login")
	public String doLogin(@ModelAttribute User u, Model model,HttpSession session,@RequestParam("g-recaptcha-response") String gCode) throws IOException {
		
	if(VerifyRecaptcha.verify(gCode)) {
			

		u.setPassword(DigestUtils.md5DigestAsHex(u.getPassword().getBytes()));
		User user = userRepo.findByUsernameAndPassword(u.getUsername(), u.getPassword());

		if (user != null) {

			log.info("====== login success===========");
			
			session.setAttribute("activeUser", user);
			session.setMaxInactiveInterval(300);
			
			//model.addAttribute("uname", u.getUsername());
			return "Home";
		}else {
			log.info("====== login failed===========");
			model.addAttribute("message", "user not found!!");
			return "LoginForm";
		}
		
  }	

		log.info("====== login failed===========");
		model.addAttribute("message", "wrong recaptch code!!");
		return "LoginForm";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		
		session.invalidate();
		log.info("====== logout success===========");
		
		return "LoginForm";
	}
	
	
}
