package com.indracompany.treinamento.model.service;

import java.util.List;

import org.apache.poi.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.indracompany.treinamento.exception.AplicacaoException;
import com.indracompany.treinamento.exception.ExceptionValidacoes;
import com.indracompany.treinamento.model.dto.ClienteDTO;
import com.indracompany.treinamento.model.entity.Cliente;
import com.indracompany.treinamento.model.entity.Conta;
import com.indracompany.treinamento.model.repository.ClienteRepository;
import com.indracompany.treinamento.model.repository.ContaRepository;
import com.indracompany.treinamento.util.CpfUtil;



@Service
public class ClienteService extends GenericCrudService<Cliente, Long, ClienteRepository>{
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
    private ContaRepository contaRepository; 
	
	
	
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
		
		boolean validacaoNome = nomeValido(nome);
		
		if(!validacaoNome) {
			
			throw new AplicacaoException(ExceptionValidacoes.ERRO_NOME_INVALIDO);
			
		}
		
		Cliente d = clienteRepository.findByNome(nome);
		
		ClienteDTO dto = new ClienteDTO();
		dto.setEmail(d.getEmail());
		dto.setNomeCompleto(d.getNome() +" " +d.getSobrenome());
		return dto;
		
	}
	
	//@GetMapping
	public List<Cliente> listar(){
		
		return clienteRepository.findAll();
		
	}
	
	
	public boolean buscarContaPorCliente(String cliente_id){
		Conta conta = contaRepository.findByFkClienteId(cliente_id);
        if(conta != null)
            return true;
        else
            return false;
    }
	
	//Validação de nome
	private boolean nomeValido(String nome) {
		if (org.apache.commons.lang3.StringUtils.isNotBlank(nome)
				&& !org.apache.commons.lang3.StringUtils.isNumeric(nome)
				&& nome.length() >= 2) {
			return true;
		}
		
		return false;
	}

	  
}
