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
        "cpf"
})
@Getter
@Setter
@XmlRootElement(name = "getClientePorCpfRequest")
public class GetClientePorCpfRequest {

    @XmlElement(required = true)
    private String cpf;


}