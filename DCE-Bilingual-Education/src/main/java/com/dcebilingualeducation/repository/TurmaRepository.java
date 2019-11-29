package com.dcebilingualeducation.repository;

import org.springframework.data.repository.CrudRepository;

import com.dcebilingualeducation.model.Turma;

public interface TurmaRepository extends CrudRepository<Turma, String>{
		Turma findByCodigo(long codigo);
	
}
	

