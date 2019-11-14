package com.dcebilingualeducation.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dcebilingualeducation.model.Aluno;
import com.dcebilingualeducation.repository.AlunoRepository;



@Controller
public class AlunoController {
	
	@Autowired
	private AlunoRepository ar;

	@RequestMapping(value = "/cadastrarAluno", method = RequestMethod.GET)
	private String form() {
		return "aluno/formAluno";
	}
	
	@RequestMapping(value = "/cadastrarAluno", method = RequestMethod.POST)
	private String form(@Valid Aluno aluno, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique os campos!");
			return "redirect:/cadastrarEvento";
		}
		
		ar.save(aluno);
		attributes.addFlashAttribute("mensagem", "Aluno Cadastrado com secesso!");

		
		return "redirect:/cadastrarAluno";
	}
	
	@RequestMapping("/alunos")
	public ModelAndView ListaAlunos() {
		ModelAndView mv = new ModelAndView("aluno/listaAlunos");
		Iterable<Aluno> alunos =ar.findAll();
		mv.addObject("alunos", alunos);
		return mv;
	}
	
	@RequestMapping("/deletarAluno")
	public String deletarAluno(long idAluno) {
		Aluno aluno = ar.findByIdAluno(idAluno);
		ar.delete(aluno);
		return "redirect:/alunos";
	}
}
