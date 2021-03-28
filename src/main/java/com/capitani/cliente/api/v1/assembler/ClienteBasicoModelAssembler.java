package com.capitani.cliente.api.v1.assembler;

import com.capitani.cliente.api.v1.CapitaniLinks;
import com.capitani.cliente.api.v1.controller.ClienteController;
import com.capitani.cliente.api.v1.model.ClienteBasicoModel;
import com.capitani.cliente.domain.model.Cliente;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

@Component
public class ClienteBasicoModelAssembler
		extends RepresentationModelAssemblerSupport<Cliente, ClienteBasicoModel> {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private CapitaniLinks capitaniLinks;

	public ClienteBasicoModelAssembler() {
		super(ClienteController.class, ClienteBasicoModel.class);
	}
	
	@Override
	public ClienteBasicoModel toModel(Cliente cliente) {
		ClienteBasicoModel clienteModel = createModelWithId(
				cliente.getId(), cliente);
		
		modelMapper.map(cliente, clienteModel);
		
		clienteModel.add(capitaniLinks.linkToClientes("clientes"));

		return clienteModel;
	}
	
	@Override
	public CollectionModel<ClienteBasicoModel> toCollectionModel(Iterable<? extends Cliente> entities) {
		return super.toCollectionModel(entities)
				.add(capitaniLinks.linkToClientes());
	}
	
}
