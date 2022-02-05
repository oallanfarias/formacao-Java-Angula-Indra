package com.indracompany.treinamento.wsbase;

import javax.xml.bind.annotation.XmlRegistry;


@XmlRegistry
public class ObjectFactory {


    public ObjectFactory() {
    }

    public GetClientePorCpfRequest createGetClientePorCpfRequest() {
        return new GetClientePorCpfRequest();
    }
    
    public GetClienteResponse createGetClienteResponse() {
        return new GetClienteResponse();
    }

    public ClienteWsModel createClienteWsModel() {
        return new ClienteWsModel();
    }

}
