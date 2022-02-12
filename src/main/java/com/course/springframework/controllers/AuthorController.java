package com.course.springframework.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.course.springframework.services.AuthorService;

@Controller
public class AuthorController {
	
	private final AuthorService authorService;
	
	public AuthorController(AuthorService authorService) {
		this.authorService = authorService;	
	}

	@GetMapping("/author/list")
	public String authorList(Model model) {
		
		model.addAttribute("authors", authorService.findAll());
		return "authors";
	}
}
