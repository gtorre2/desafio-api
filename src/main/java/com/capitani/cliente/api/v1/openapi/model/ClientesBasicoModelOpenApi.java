package com.capitani.cliente.api.v1.openapi.model;

import com.capitani.cliente.api.v1.model.ClienteBasicoModel;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import org.springframework.hateoas.Links;

import java.util.List;

@ApiModel("ClientesBasicoModel")
@Data
public class ClientesBasicoModelOpenApi {

	private ClientesEmbeddedModelOpenApi _embedded;
	private Links _links;
	
	@ApiModel("ClientesEmbeddedModel")
	@Data
	public class ClientesEmbeddedModelOpenApi {
		
		private List<ClienteBasicoModel> clientes;
		
	}
	
}
