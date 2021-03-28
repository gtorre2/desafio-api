package com.capitani.cliente.api.v1.assembler;

import com.capitani.cliente.api.v1.CapitaniLinks;
import com.capitani.cliente.api.v1.controller.ClienteController;
import com.capitani.cliente.api.v1.model.ClienteApenasNomeModel;
import com.capitani.cliente.domain.model.Cliente;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

@Component
public class ClienteApenasNomeModelAssembler
		extends RepresentationModelAssemblerSupport<Cliente, ClienteApenasNomeModel> {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private CapitaniLinks algaLinks;

	public ClienteApenasNomeModelAssembler() {
		super(ClienteController.class, ClienteApenasNomeModel.class);
	}
	
	@Override
	public ClienteApenasNomeModel toModel(Cliente cliente) {
		ClienteApenasNomeModel clienteModel = createModelWithId(
				cliente.getId(), cliente);
		
		modelMapper.map(cliente, clienteModel);

		clienteModel.add(algaLinks.linkToClientes("clientes"));
		
		return clienteModel;
	}
	
	@Override
	public CollectionModel<ClienteApenasNomeModel> toCollectionModel(Iterable<? extends Cliente> entities) {
		return super.toCollectionModel(entities)
				.add(algaLinks.linkToClientes());
	}
	
}
