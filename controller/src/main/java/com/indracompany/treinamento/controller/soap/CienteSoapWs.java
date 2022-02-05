package com.indracompany.treinamento.controller.soap;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.indracompany.treinamento.model.dto.ClienteDTO;
import com.indracompany.treinamento.model.service.ClienteService;
import com.indracompany.treinamento.wsbase.ClienteWsModel;
import com.indracompany.treinamento.wsbase.GetClientePorCpfRequest;
import com.indracompany.treinamento.wsbase.GetClientePorNomeRequest;
import com.indracompany.treinamento.wsbase.GetClienteResponse;


@Endpoint(value = "/clientes")
public class CienteSoapWs {
	
	private static final String NAMESPACE_URI = "http://indracompany.com/treinamento/wsbase";

	@Autowired
	private ClienteService clienteService;

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getClientePorCpfRequest")
	@ResponsePayload
	public GetClienteResponse getClientePorCpf(@RequestPayload GetClientePorCpfRequest request) {
		GetClienteResponse response = new GetClienteResponse();
		
		ClienteDTO dto = clienteService.buscarClientePorCpf(request.getCpf());
		ClienteWsModel model = new ClienteWsModel();
		
		BeanUtils.copyProperties(dto, model);
		

		response.setCliente(model);
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getClientePorNomeRequest")
	@ResponsePayload
	public GetClienteResponse getClientePorNome(@RequestPayload GetClientePorNomeRequest request) {
		GetClienteResponse response = new GetClienteResponse();
		
		ClienteDTO dto = clienteService.buscarClientePorNome(request.getNome());
		ClienteWsModel model = new ClienteWsModel();
		
		BeanUtils.copyProperties(dto, model);
		

		response.setCliente(model);
		return response;
	}
	
	

}