package com.capitani.cliente.api.v1.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import javax.persistence.Embedded;

@Relation(collectionRelation = "clientes")
@Setter
@Getter
public class ClienteBasicoModel extends RepresentationModel<ClienteBasicoModel> {

	@ApiModelProperty(example = "1")
	private Long id;
	
	@ApiModelProperty(example = "Gustavo")
	private String nome;

	@ApiModelProperty(example = "gtorre23@gmail.com")
	private String email;

	@ApiModelProperty(example = "00782112-34")
	private String cpf;

	@ApiModelProperty(example = "72939-000")
	private String cep;

	@Embedded
	private EnderecoClienteModel enderecoClienteModel;

}
