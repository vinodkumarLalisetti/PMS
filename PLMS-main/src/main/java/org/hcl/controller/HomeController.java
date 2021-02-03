package org.hcl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	@GetMapping("/")
	public String showhome() {
		return "home";
	}

	@GetMapping("/home")
	public String showAgainhome() {
		return "home";
	}
}