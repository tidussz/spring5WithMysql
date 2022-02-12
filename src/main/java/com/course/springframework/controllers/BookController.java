package com.course.springframework.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.course.springframework.services.BookService;

@Controller
public class BookController {
	
	private final BookService bookService;
	
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}

	@GetMapping("/book/list")
	public String authorList(@RequestParam(value="author", required=false) Long author,
			Model model) {
		
		if (author != null) {
			model.addAttribute("books", bookService.findByAuthorId(author));
		}
		else {
			model.addAttribute("books", bookService.findAll());
		}
		
		return "books";
	}
}
