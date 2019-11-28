package com.dcebilingualeducation.repository;

import org.springframework.data.repository.CrudRepository;

import com.dcebilingualeducation.model.Professor;

public interface ProfessorRepository extends CrudRepository<Professor, String>{
	Professor findByIdProfessor(long idProfessor);
	Professor findByMatricula(String matricula);

}
