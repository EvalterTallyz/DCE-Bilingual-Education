package com.dcebilingualeducation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class indexController {

	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("cursos")
	public String cursos() {
		return "cursos";
	}
	
	@RequestMapping("login")
	public String login() {
		return "login";
	}
	
	@RequestMapping("fazerLogin")
	public String fazerLogin() {
		return "fazerLogin";
	}
	
	
	
	
	
	
	
	
}
