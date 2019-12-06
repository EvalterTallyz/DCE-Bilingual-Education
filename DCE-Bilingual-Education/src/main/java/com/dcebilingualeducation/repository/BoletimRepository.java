package com.dcebilingualeducation.repository;

import org.springframework.data.repository.CrudRepository;

import com.dcebilingualeducation.model.Boletim;

public interface BoletimRepository extends CrudRepository<Boletim, String>{
		Boletim findByIdBoletim(long idBoletim);
	
}
