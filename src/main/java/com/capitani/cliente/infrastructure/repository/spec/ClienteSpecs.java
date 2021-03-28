package com.capitani.cliente.infrastructure.repository.spec;

import com.capitani.cliente.domain.model.Cliente;
import org.springframework.data.jpa.domain.Specification;

public class ClienteSpecs {

	public static Specification<Cliente> comNomeSemelhante(String nome) {
		return (root, query, builder) ->
			builder.like(root.get("nome"), "%" + nome + "%");
	}
	
}
