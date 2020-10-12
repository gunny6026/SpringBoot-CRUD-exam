package com.cos.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // viewResolver
public class HomeController {

	@GetMapping("/home")
	public String home() {

		//  src/main.webapp/WEB-INF/views/home.jsp
		return "home";
	}
}
