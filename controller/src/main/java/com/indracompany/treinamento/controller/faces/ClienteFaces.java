package com.indracompany.treinamento.controller.faces;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.SystemException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.indracompany.treinamento.model.entity.Cliente;
import com.indracompany.treinamento.model.service.ClienteService;
import com.indracompany.treinamento.util.FacesUtil;

import lombok.Data;

@Data
@Component
@Scope(value = "session")
public class ClienteFaces  {

	private static final String PAGINA_MANTER = "/paginas/cliente/manterCliente.jsf";
	
	private Cliente cliente = new Cliente();
	
	@Autowired
	private ClienteService clienteService;

	
	private List<Cliente> clientes;

	@PostConstruct
	public void resetar() throws SystemException {
		cliente = new Cliente();
		clientes = (List<Cliente>) clienteService.listar();
	}


}
	