package com.bway.springdemo.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {
	
	@GetMapping("/upload")
	public String showUpload() {
		
		return "Upload";
	}
	
	@PostMapping("/upload")
	public String saveImage(@RequestParam("image") MultipartFile img, Model model ) {
		
		
		if(!img.isEmpty()) {
			
			try {
				
				Files.copy(img.getInputStream(), Path.of("src/main/resources/static/images/"+img.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING);
				model.addAttribute("message","upload success");
				return  "Upload";
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		model.addAttribute("message","upload failed");
		return  "Upload";
	}

}
