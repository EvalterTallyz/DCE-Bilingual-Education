package com.dcebilingualeducation.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dcebilingualeducation.model.Professor;
import com.dcebilingualeducation.repository.ProfessorRepository;

@Controller
public class ProfessorController {

	@Autowired
	private ProfessorRepository pr;

	@RequestMapping(value = "/cadastrarProfessor", method = RequestMethod.GET)
	private String form() {
		return "professor/formprofessor";
	}
	
	@RequestMapping(value = "/cadastrarProfessor", method = RequestMethod.POST)
	private String form(@Valid Professor professor, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique os campos!");
			return "redirect:/cadastrarProfessor";
		}
		
		pr.save(professor);
		attributes.addFlashAttribute("mensagem", "Professor Cadastrado com secesso!");

		
		return "redirect:/cadastrarProfessor";
	}
	
	@RequestMapping("/professores")
	public ModelAndView ListaProfessores() {
		ModelAndView mv = new ModelAndView("professor/listaProfessores");
		Iterable<Professor> professores =pr.findAll();
		mv.addObject("professores", professores);
		return mv;
	}
	
	@RequestMapping("/deletarProfessor")
	public String deletarProfessor(long idProfessor) {
		Professor professor = pr.findByIdProfessor(idProfessor);
		pr.delete(professor);
		return "redirect:/professores";
	}
}
