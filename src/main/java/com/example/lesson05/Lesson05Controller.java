package com.example.lesson05;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/lesson05")
@Controller
public class Lesson05Controller {
	
	@GetMapping("/ex03")
	public String ex03(Model model) {
		
		Date now = new Date();
		model.addAttribute("now", now);
		
		return "lesson05/ex03";
	}
	
	@GetMapping("/ex04")
	public String ex04() {
		return "lesson05/ex04";
	}
}
