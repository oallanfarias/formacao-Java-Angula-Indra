package com.indracompany.treinamento.controller.faces;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
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
		
		for(Cliente clienteFor : clientes) {
			boolean isConta = clienteService.buscarContaPorCliente(clienteFor.getId().toString());
			if(isConta) {
				clienteFor.setPossuiConta("Sim");
			}else {
				clienteFor.setPossuiConta("Não");
			}
		}
	}
	
	public void save() {
		clienteService.salvar(cliente);
		cliente = new Cliente();
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new  FacesMessage(FacesMessage.SEVERITY_INFO, "Cliente Cadastrado com Sucesso!", ""));
	}


}
	