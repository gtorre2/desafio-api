package com.capitani.cliente.domain.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class EnderecoDTO implements Serializable {

    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;

}
