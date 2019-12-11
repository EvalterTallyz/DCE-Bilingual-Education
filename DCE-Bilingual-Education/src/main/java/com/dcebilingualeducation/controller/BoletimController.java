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
import com.dcebilingualeducation.model.Boletim;
import com.dcebilingualeducation.repository.AlunoRepository;
import com.dcebilingualeducation.repository.BoletimRepository;

@Controller
public class BoletimController {

		@Autowired
		private BoletimRepository br;
				
	
		@RequestMapping(value = "/cadastrarBoletim", method = RequestMethod.GET)
		private String form() {
			return "boletim/formBoletim";
		}
		
		@RequestMapping(value = "/cadastrarBoletim", method = RequestMethod.POST)
		private String form(@Valid Boletim boletim, BindingResult result, RedirectAttributes attributes) {
			if (result.hasErrors()) {
				attributes.addFlashAttribute("mensagem", "Verifique os campos!");
				return "redirect:/cadastrarBoletim";
			}
			
			br.save(boletim);
			attributes.addFlashAttribute("mensagem", "Boletim Cadastrado com secesso!");

			
			return "redirect:/cadastrarBoletim";
		}
		
		@RequestMapping("/boletins")
		public ModelAndView ListaBoletim() {
			ModelAndView mv = new ModelAndView("boletim/listarBoletim");
			Iterable<Boletim> boletins =br.findAll();
			mv.addObject("boletins", boletins);
			return mv;
		}
		@RequestMapping("/boletinsA")
		public ModelAndView ListaBoletimA() {
			ModelAndView mv = new ModelAndView("boletim/listarBoletimA");
			Iterable<Boletim> boletins =br.findAll();
			mv.addObject("boletins", boletins);
			return mv;
		}
		
		@RequestMapping("/deletarBoletim")
		public String deletarBoletim(long idBoletim) {
			Boletim boletim = br.findByIdBoletim(idBoletim);
			br.delete(boletim);
			return "redirect:/boletins";
		}
	}
