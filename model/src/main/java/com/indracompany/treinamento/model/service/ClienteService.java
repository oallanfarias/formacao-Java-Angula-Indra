package com.indracompany.treinamento.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indracompany.treinamento.exception.AplicacaoException;
import com.indracompany.treinamento.exception.ExceptionValidacoes;
import com.indracompany.treinamento.model.dto.ClienteDTO;
import com.indracompany.treinamento.model.entity.Cliente;
import com.indracompany.treinamento.model.repository.ClienteRepository;
import com.indracompany.treinamento.util.CpfUtil;

@Service
public class ClienteService extends GenericCrudService<Cliente, Long, ClienteRepository>{
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	
	
	public ClienteDTO buscarClientePorCpf(String cpf) {
		
		boolean cpfValido = CpfUtil.validaCPF(cpf);

		if (!cpfValido) {
			throw new AplicacaoException(ExceptionValidacoes.ERRO_CPF_INVALIDO);
		}
		
		Cliente c = clienteRepository.findByCpf(cpf);
		
		ClienteDTO dto = new ClienteDTO();
		dto.setEmail(c.getEmail());
		dto.setNomeCompleto(c.getNome() +" " +c.getSobrenome());
		return dto;
		
	}
	
	public ClienteDTO buscarClientePorNome(String nome) {
		
				
		Cliente c = clienteRepository.findByNome(nome);
		
		ClienteDTO dto = new ClienteDTO();
		dto.setEmail(c.getEmail());
		dto.setNomeCompleto(c.getNome() +" " +c.getSobrenome());
		return dto;
		
	}
	

	  
}
