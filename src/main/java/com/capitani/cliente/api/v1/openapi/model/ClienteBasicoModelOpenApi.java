package com.capitani.cliente.api.v1.openapi.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel("ClienteBasicoModel")
@Setter
@Getter
public class ClienteBasicoModelOpenApi {

	@ApiModelProperty(example = "1")
	private Long id;
	
	@ApiModelProperty(example = "Gustavo")
	private String nome;

	@ApiModelProperty(example = "gtorre23@gmail.com")
	private String email;

	@ApiModelProperty(example = "00782112-34")
	private String cpf;

	@ApiModelProperty(example = "71939-000")
	private String cep;
	
}
