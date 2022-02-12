package com.indracompany.treinamento.controller.servlet;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("jsp/clientes")
public class ClientesServlet {

	private String message = "Hello Clientes";

	@RequestMapping("/listar")
	public String welcome(Map<String, Object> model) {
		model.put("message", this.message);
		return "listarClientes";
	}

}