package com.dcebilingualeducation.repository;

import org.springframework.data.repository.CrudRepository;

import com.dcebilingualeducation.model.Aluno;


public interface AlunoRepository extends CrudRepository<Aluno, String>{
	Aluno findByIdAluno(long idAluno);
	Aluno findByMatricula(String matricula);
	
}
