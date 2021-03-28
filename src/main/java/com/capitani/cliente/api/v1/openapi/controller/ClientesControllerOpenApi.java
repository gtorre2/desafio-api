package com.capitani.cliente.api.v1.openapi.controller;

import com.capitani.cliente.api.exceptionhandler.Problem;
import com.capitani.cliente.api.v1.model.ClienteModel;
import com.capitani.cliente.api.v1.model.input.ClienteInput;
import com.capitani.cliente.api.v1.model.ClienteBasicoModel;
import io.swagger.annotations.*;
import org.springframework.hateoas.CollectionModel;

@Api(tags = "Clientes")
public interface ClientesControllerOpenApi {

	@ApiOperation(value = "Lista clientes")
	@ApiImplicitParams({
			@ApiImplicitParam(value = "Nome da projeção de clientes", allowableValues = "apenas-nome",
					name = "projecao", paramType = "query", type = "string")
	})
	CollectionModel<ClienteBasicoModel> listar();
	
	@ApiOperation("Busca um cliente por email")
	@ApiResponses({
		@ApiResponse(code = 400, message = "Email do clientes inválido", response = Problem.class),
		@ApiResponse(code = 404, message = "Clientes não encontrado", response = Problem.class)
	})
    ClienteModel buscar(
			@ApiParam(value = "E-mail de um cliente", example = "gtorre23@gmail.com", required = true)
			String email);
	
	@ApiOperation("Cadastra um cliente")
	@ApiResponses({
		@ApiResponse(code = 201, message = "Cliente cadastrado"),
	})
	ClienteModel adicionar(
			@ApiParam(name = "corpo", value = "Representação de um novo cliente", required = true)
                    ClienteInput clienteInput);

}
