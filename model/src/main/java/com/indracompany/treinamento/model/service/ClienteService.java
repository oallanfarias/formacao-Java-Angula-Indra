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
<<<<<<< HEAD
		dto.setCpf(c.getCpf());
		return dto;
		
	}



	public ClienteDTO buscarClientePorNome(String nome) {
		
		boolean nomeValido = ehNomeValido(nome);
		
		if (!nomeValido) {
			throw new AplicacaoException(ExceptionValidacoes.ERRO_NOME_INVALIDO);
		}
		Cliente c = clienteRepository.findByNome(nome);
		
		
		ClienteDTO dto = new ClienteDTO();
		dto.setEmail(c.getEmail());
		dto.setNomeCompleto(c.getNome() +" " +c.getSobrenome());
		dto.setCpf(c.getCpf());
=======
>>>>>>> 23caac625b149cfed0b8c7fece7c7daa79670b65
		return dto;
		
	}
	
<<<<<<< HEAD
      public ClienteDTO buscarClientePornome(String nome) {
   		
    	Cliente c = clienteRepository.findBynome(nome);
		
		ClienteDTO dto = new ClienteDTO();
		dto.setEmail(c.getEmail());
		dto.setNomeCompleto(c.getNome() +" " +c.getSobrenome());
		return dto;
		
	}

=======
	
	public ClienteDTO buscarClientePorNome(String nome) {
		Cliente d = clienteRepository.findByNome(nome);
		
		ClienteDTO dto = new ClienteDTO();
		dto.setEmail(d.getEmail());
		dto.setNomeCompleto(d.getNome() +" " +d.getSobrenome());
		return dto;
		

	}
>>>>>>> 109289f0f51111b3d3966fdaab2120a358aad652

	  
}
