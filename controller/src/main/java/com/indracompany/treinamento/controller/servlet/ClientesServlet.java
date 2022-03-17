package com.indracompany.treinamento.controller.servlet;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.indracompany.treinamento.model.entity.Cliente;
import com.indracompany.treinamento.model.service.ClienteService;

@Controller
@RequestMapping("jsp/clientes")
public class ClientesServlet {

	//private String message = "Hello Clientes";
	
	//private ClienteService clienteService = new ClienteService();
	
	//essa anotation instancia
	@Autowired
	private ClienteService clienteService;
	

	@RequestMapping("/listar")
	public String listar(Map<String, Object> model, HttpSession session) {
		//model.put("message", this.message);
		
		List<Cliente> listaCliente = clienteService.listar();
		session.setAttribute("lista", listaCliente);
		
		for(Cliente clienteFor : listaCliente) {
			boolean isConta = clienteService.buscarContaPorCliente(clienteFor.getId().toString());
			if(isConta) {
				clienteFor.setPossuiConta("Sim");
			}else {
				clienteFor.setPossuiConta("Não");
			}
		}
		
		return "listarClientes";
	}
	
	@RequestMapping("/cadastrar")
	public String cadastrar(Map<String, Object> model) {
		
		return "cadastrarClientes";
	}
	
	@RequestMapping("/cadastrarBanco")
	public String cadastrarBanco(Map<String, Object> model, HttpServletRequest request) {
		
		Cliente cliente = new Cliente();
		cliente.setNome(request.getParameter("edtNome"));
		cliente.setSobrenome(request.getParameter("edtSobrenome"));
		cliente.setCpf(request.getParameter("edtCPF"));
		cliente.setEmail(request.getParameter("edtEmail"));
		cliente.setAtivo(true);
		
		clienteService.salvar(cliente);
		
		return "cadastrarClientes";
	}

}