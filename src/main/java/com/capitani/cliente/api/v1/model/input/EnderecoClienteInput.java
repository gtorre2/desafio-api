package com.capitani.cliente.api.v1.model.input;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EnderecoClienteInput {

	@ApiModelProperty(example = "Rua Floriano Peixoto", required = true)
	private String logradouro;
	
	@ApiModelProperty(example = "\"1500\"", required = true)
	private String numero;
	
	@ApiModelProperty(example = "Apto 901")
	private String complemento;
	
	@ApiModelProperty(example = "Centro", required = true)
	private String bairro;

}
