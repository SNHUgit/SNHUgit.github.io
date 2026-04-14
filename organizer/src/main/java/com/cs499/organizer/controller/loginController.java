package com.cs499.organizer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class loginController {

    @GetMapping("/login")
    public String loginPage() {
	return "login";
    }
    
    @GetMapping("/non-auth")
    public String nonAuth() {
        return "non-auth";
    }
}
