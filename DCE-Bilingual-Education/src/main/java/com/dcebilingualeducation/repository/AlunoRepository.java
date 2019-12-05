package com.dcebilingualeducation.repository;

import org.springframework.data.repository.CrudRepository;

import com.dcebilingualeducation.model.Aluno;
import com.dcebilingualeducation.model.Turma;

public interface AlunoRepository extends CrudRepository<Aluno, String>{
		Iterable<Aluno> findByTurma(Turma turma);
		Aluno findByIdAluno(long id);
}
	
