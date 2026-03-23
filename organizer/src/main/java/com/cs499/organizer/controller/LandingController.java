package com.cs499.organizer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LandingController {

	//create mapping for home page
	
	@GetMapping("/")
	public String homePage() {
				
		return "landing";
	}
	
}
