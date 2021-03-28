package com.capitani.cliente.api.v1.controller;

import com.capitani.cliente.api.v1.assembler.ClienteApenasNomeModelAssembler;
import com.capitani.cliente.api.v1.assembler.ClienteBasicoModelAssembler;
import com.capitani.cliente.api.v1.assembler.ClienteInputDisassembler;
import com.capitani.cliente.api.v1.assembler.ClienteModelAssembler;
import com.capitani.cliente.api.v1.model.ClienteModel;
import com.capitani.cliente.api.v1.model.input.ClienteInput;
import com.capitani.cliente.api.v1.openapi.controller.ClientesControllerOpenApi;
import com.capitani.cliente.domain.exception.ClienteJáExistenteException;
import com.capitani.cliente.domain.exception.NegocioException;
import com.capitani.cliente.domain.model.Cliente;
import com.capitani.cliente.domain.model.dto.EnderecoDTO;
import com.capitani.cliente.domain.repository.ClienteRepository;
import com.capitani.cliente.domain.service.CadastroClienteService;
import com.capitani.cliente.api.v1.model.ClienteBasicoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(path = "/v1/clientes", produces = MediaType.APPLICATION_JSON_VALUE)
public class ClienteController implements ClientesControllerOpenApi {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private CadastroClienteService cadastroCliente;
	
	@Autowired
	private ClienteModelAssembler clienteModelAssembler;
	
	@Autowired
	private ClienteBasicoModelAssembler clienteBasicoModelAssembler;
	
	@Autowired
	private ClienteApenasNomeModelAssembler clienteApenasNomeModelAssembler;
	
	@Autowired
	private ClienteInputDisassembler clienteInputDisassembler;

	@Autowired
	private PagedResourcesAssembler<Cliente> pagedResourcesAssembler;

	@Override
	@GetMapping
	public CollectionModel<ClienteBasicoModel> listar() {
		return clienteBasicoModelAssembler
				.toCollectionModel(clienteRepository.findAll());
	}

	@Override
	@GetMapping("/{email}")
	public ClienteModel buscar(@PathVariable String email) {
		Cliente cliente = cadastroCliente.buscarOuFalhar(email);
		
		return clienteModelAssembler.toModel(cliente);
	}
	
	@Override
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ClienteModel adicionar(@RequestBody @Valid ClienteInput clienteInput) {
		try {
			Cliente cliente = clienteInputDisassembler.toDomainObject(clienteInput);
			ResponseEntity<EnderecoDTO> enderecoDTO = buscarCEP(clienteInput.getCep());

			Optional<Cliente> clienteExistente = clienteRepository.findFirstClienteByEmailAndCpfContaining(clienteInput.getEmail(), clienteInput.getCpf());

			if(!clienteExistente.isPresent()) {
				return clienteModelAssembler.toModel(cadastroCliente.salvar(cliente, enderecoDTO.getBody()));
			} else {
				throw new ClienteJáExistenteException();
			}

		} catch (ClienteJáExistenteException e) {
			throw new NegocioException(e.getMessage());
		}
	}

	public ResponseEntity<EnderecoDTO> buscarCEP(String cep) {
		RestTemplate restTemplate = new RestTemplate();

		String uri = "http://viacep.com.br/ws/{cep}/json/";

		Map<String, String> params = new HashMap<>();
		params.put("cep", cep);

		EnderecoDTO enderecoTO = restTemplate.getForObject(uri, EnderecoDTO.class, params);

		return new ResponseEntity<>(enderecoTO, HttpStatus.OK);
	}

}
