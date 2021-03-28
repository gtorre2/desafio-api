package com.capitani.cliente.api.v1;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import com.capitani.cliente.api.v1.controller.ClienteController;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.TemplateVariable;
import org.springframework.hateoas.TemplateVariable.VariableType;
import org.springframework.hateoas.TemplateVariables;
import org.springframework.hateoas.UriTemplate;
import org.springframework.stereotype.Component;

@Component
public class CapitaniLinks {

	public static final TemplateVariables PAGINACAO_VARIABLES = new TemplateVariables(
			new TemplateVariable("page", VariableType.REQUEST_PARAM),
			new TemplateVariable("size", VariableType.REQUEST_PARAM),
			new TemplateVariable("sort", VariableType.REQUEST_PARAM));

	public static final TemplateVariables PROJECAO_VARIABLES = new TemplateVariables(
			new TemplateVariable("projecao", VariableType.REQUEST_PARAM));

	public Link linkToCliente(String email, String rel) {
		return linkTo(methodOn(ClienteController.class)
				.buscar(email)).withRel(rel);
	}

	public Link linkToCliente(String email) {
		return linkToCliente(email, IanaLinkRelations.SELF.value());
	}

	public Link linkToClientes(String rel) {
		String clientesUrl = linkTo(ClienteController.class).toUri().toString();

		return new Link(UriTemplate.of(clientesUrl, PROJECAO_VARIABLES), rel);
	}

	public Link linkToClientes() {
		return linkToClientes(IanaLinkRelations.SELF.value());
	}

}
