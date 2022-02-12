package com.indracompany.treinamento.model.service;

import org.apache.commons.lang3.StringUtils;
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
		return dto;
		
	}
	
	private boolean ehNomeValido(String nome) {
		if (StringUtils.isNotBlank(nome) 
				&& !StringUtils.isNumeric(nome)
				&& nome.length() >= 2) {
			return true;
		}
		return false;
	}


	  
}
