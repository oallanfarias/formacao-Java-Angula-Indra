package com.indracompany.treinamento.model.repository;

import com.indracompany.treinamento.model.entity.Cliente;

public interface ClienteRepository extends GenericCrudRepository<Cliente, Long>{
	
<<<<<<< HEAD
	public Cliente findByCpf(@Param("cpf")String cpf);
	
	public Cliente findBynome(@Param("nome")String nome);
=======
	public Cliente findByCpf(String cpf);

	public Cliente findByNome(String nome);
>>>>>>> 109289f0f51111b3d3966fdaab2120a358aad652

	

}
