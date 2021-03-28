package com.capitani.cliente.api.v1.model.input;

import com.capitani.cliente.api.v1.model.EnderecoClienteModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

@Relation(collectionRelation = "clientes")
@Setter
@Getter
public class ClienteModel extends RepresentationModel<ClienteModel> {

	@ApiModelProperty(example = "1")
	private Long id;
	
	@ApiModelProperty(example = "Gustavo Rodrigues Torre")
	private String nome;

	@ApiModelProperty(example = "gtorre23@gmail.com")
	private String email;

	@ApiModelProperty(example = "72939-000")
	private String cep;
	
	private EnderecoClienteModel endereco;
	
}
