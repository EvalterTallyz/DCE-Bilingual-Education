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
	
	@RequestMapping("Home_Aluno")
	public String aluno() {
		return "indexAluno";
	}
	
	@RequestMapping("Home_Professor")
	public String prof() {
		return "indexProf";
	}
	
	@RequestMapping("Home_ADMIN")
	public String admin() {
		return "indexADM";
	}
	
	
}
