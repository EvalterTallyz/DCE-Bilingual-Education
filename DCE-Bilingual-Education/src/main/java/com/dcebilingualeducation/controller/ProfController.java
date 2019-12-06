package com.dcebilingualeducation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProfController {

	@RequestMapping("Home_Professor")
	public String prof() {
		return "indexProf";
	}
}
