package com.capitani.cliente.domain.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Embeddable
public class EnderecoCliente {

	@Column(name = "endereco_logradouro")
	private String logradouro;
	
	@Column(name = "endereco_numero")
	private String numero;
	
	@Column(name = "endereco_complemento")
	private String complemento;
	
	@Column(name = "endereco_bairro")
	private String bairro;

	@Column(name = "endereco_cidade")
	private String cidade;
	
}
