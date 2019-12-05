package com.dcebilingualeducation.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dcebilingualeducation.model.Aluno;
import com.dcebilingualeducation.model.Turma;
import com.dcebilingualeducation.repository.AlunoRepository;
import com.dcebilingualeducation.repository.TurmaRepository;

@Controller
public class TurmaController {

		@Autowired
		private TurmaRepository tr;
		
		@Autowired
		private AlunoRepository ar;
		
		@RequestMapping(value="/cadastrarTurma", method=RequestMethod.GET)
		public String form() {
			return "turma/formTurma";	
		}
		
		@RequestMapping(value="/cadastrarTurma", method=RequestMethod.POST)
		public String form(@Valid Turma turma, BindingResult result, RedirectAttributes attributes) {
			if(result.hasErrors()) {
				attributes.addFlashAttribute("mensagem", "Verifique os campos!");
				return "redirect:/cadastrarTurma";
			}
			tr.save(turma);
			attributes.addFlashAttribute("mensagem", "Turma cadastrada com sucesso!");
			return "redirect:/cadastrarTurma";	
			
		}
		
		@RequestMapping("/turmas")
		public ModelAndView listaTurmas(){
			ModelAndView mv = new ModelAndView("index");
			Iterable<Turma> turmas = tr.findAll();
			mv.addObject("turmas", turmas);
			return mv;
		}
		
		@RequestMapping(value="/{codigo}", method=RequestMethod.GET)
		public ModelAndView detalhesTurma(@PathVariable("codigo") long codigo) {
			Turma turma =tr.findByCodigo(codigo);
			ModelAndView mv = new ModelAndView("turma/detalhesTurma");
			mv.addObject("turma", turma);
			
			Iterable<Aluno> alunos = ar.findByTurma(turma);
			mv.addObject("alunos", alunos);
			
			return mv;
		}
		
		@RequestMapping("/deletarTurma")
		public String deletarTurma(long codigo) {
			Turma turma = tr.findByCodigo(codigo);
			tr.delete(turma);
			return "redirect:/turmas";
		}
		
		@RequestMapping(value="/{codigo}", method=RequestMethod.POST)
		public String detalhesTurmaPost(@PathVariable("codigo") long codigo, @Valid Aluno aluno, BindingResult result, RedirectAttributes attributes) {
			if(result.hasErrors()) {
				attributes.addFlashAttribute("mensagem", "Verifique os campos!");
				return "redirect:/{codigo}";
			}
			Turma turma = tr.findByCodigo(codigo);
			aluno.setTurma(turma);
			ar.save(aluno);
			attributes.addFlashAttribute("mensagem", "Aluno adicionado com sucesso!");
			return "redirect:/{codigo}";
		}
		
		@RequestMapping("/deletarAluno")
		public String deletarAluno(long id) {
			Aluno aluno = ar.findByIdAluno(id);
			ar.delete(aluno);
			
			Turma turma = aluno.getTurma();
			long codigoLong = turma.getCodigo();
			String codigo = "" + codigoLong;
			return "redirect:/" + codigo;
		}
	
}
