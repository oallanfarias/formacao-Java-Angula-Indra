package com.indracompany.treinamento.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.indracompany.treinamento.exception.AplicacaoException;
import com.indracompany.treinamento.model.dto.ClienteDTO;
import com.indracompany.treinamento.model.entity.Cliente;
import com.indracompany.treinamento.model.service.ClienteService;

@RestController
@RequestMapping("rest/clientes")
public class ClienteRest extends GenericCrudRest<Cliente, Long, ClienteService>{
	
	@Autowired
	private ClienteService clienteService;
	


	@RequestMapping(value = "/buscar-cliente-por-cpf/{cpf}", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<ClienteDTO> buscarClientePorCpf(@PathVariable String cpf) throws AplicacaoException {
		ClienteDTO c = clienteService.buscarClientePorCpf(cpf);
		if (c== null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND) ;
		} else {
			return new ResponseEntity<>(c, HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/buscar-cliente-por-nome/{nome}", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<ClienteDTO> buscarClientePornome(@PathVariable String nome) throws AplicacaoException {
		ClienteDTO c = clienteService.buscarClientePornome(nome);
		if (c== null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND) ;
		} else {
			return new ResponseEntity<>(c, HttpStatus.OK);
		}
	}
}
