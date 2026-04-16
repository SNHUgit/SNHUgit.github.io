package com.cs499.organizer.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

	// Handles shared application errors.
	// Includes:
	// - catching common exceptions
	// - sending users to the error page
	
	// Catches illegal argument errors and shows a cleaner message to the user.
    @ExceptionHandler(IllegalArgumentException.class)
    public String handleIllegalArgument(IllegalArgumentException ex, Model model) {
        model.addAttribute("errorMessage", ex.getMessage());
        return "error";
    }

}