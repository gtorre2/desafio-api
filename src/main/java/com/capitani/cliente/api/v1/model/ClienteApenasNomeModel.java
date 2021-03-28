package com.capitani.cliente.api.v1.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

@Relation(collectionRelation = "clientes")
@Setter
@Getter
public class ClienteApenasNomeModel extends RepresentationModel<ClienteApenasNomeModel> {

	@ApiModelProperty(example = "1")
	private Long id;
	
	@ApiModelProperty(example = "Gustavo")
	private String nome;
	
}
