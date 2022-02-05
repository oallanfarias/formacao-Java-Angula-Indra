
package com.indracompany.treinamento.wsbase;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import lombok.Getter;
import lombok.Setter;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "clienteWsModel", propOrder = {
    "nomeCompleto",
    "email",
    "cpf"
})
@Getter
@Setter
public class ClienteWsModel {

    @XmlElement(required = true)
    private String nomeCompleto;
    @XmlElement(required = true)
    private String email;
    @XmlElement(required = true)
    private String cpf;


}
