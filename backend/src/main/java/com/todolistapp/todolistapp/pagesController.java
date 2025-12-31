package com.todolistapp.todolistapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class pagesController {

	@GetMapping("/")
	public String redirect()
	{
		return "redirect:/api";
	}

	@GetMapping("/api")
	public String welcome()
	{
		return "index";
	}
}
