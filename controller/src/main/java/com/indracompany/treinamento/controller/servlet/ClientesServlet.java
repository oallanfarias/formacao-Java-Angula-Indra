package com.indracompany.treinamento.controller.servlet;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.indracompany.treinamento.model.entity.Cliente;
import com.indracompany.treinamento.model.service.ClienteService;

@Controller
@RequestMapping("jsp/clientes")
public class ClientesServlet {

	@Autowired
	private ClienteService clienteService;


	@RequestMapping("/listar")
	public String listar(Map<String, Object> model, HttpServletRequest session) {
		
		List<Cliente> listaCliente = clienteService.listar();
		session.setAttribute("lista", listaCliente);
		
		
		return "listarClientes";
	}

}