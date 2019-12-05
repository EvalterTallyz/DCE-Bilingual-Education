package com.dcebilingualeducation.repository;

import org.springframework.data.repository.CrudRepository;

import com.dcebilingualeducation.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, String>{
	
	Usuario findByMatricula(String matricula);

}
