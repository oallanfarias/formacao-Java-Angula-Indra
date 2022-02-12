package com.indracompany.treinamento.model.repository;

import org.springframework.data.repository.query.Param;

import com.indracompany.treinamento.model.entity.Cliente;

public interface ClienteRepository extends GenericCrudRepository<Cliente, Long>{
	

	public Cliente findByCpf(@Param("cpf")String cpf);
	
	public Cliente findBynome(@Param("nome")String nome);


	
	

}
