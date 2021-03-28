package com.capitani.cliente.api.v1.model.input;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Setter
@Getter
public class ClienteInput {

	@ApiModelProperty(example = "Gustavo", required = true)
	@NotBlank
	private String nome;

	@ApiModelProperty(example = "gtorre23@gmail.com", required = true)
	@NotBlank
	private String email;

	@ApiModelProperty(example = "71933-000", required = true)
	@NotBlank
	private String cep;

	@ApiModelProperty(example = "00782112-34", required = true)
	@NotBlank
	private String cpf;

	private EnderecoClienteInput endereco;

}
