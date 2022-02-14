package com.indracompany.treinamento.wsbase;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import lombok.Getter;
import lombok.Setter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "cliente"
})
@XmlRootElement(name = "getClienteResponse")
@Getter
@Setter
public class GetClienteResponse {

    @XmlElement(required = true)
    private ClienteWsModel cliente;



}
