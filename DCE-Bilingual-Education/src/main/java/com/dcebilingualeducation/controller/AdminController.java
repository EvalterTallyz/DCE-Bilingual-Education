package com.dcebilingualeducation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

	@RequestMapping("/ADMIN/indexAdmin")
	public String admin() {
		return "indexAdm";
	}
	
	
}
