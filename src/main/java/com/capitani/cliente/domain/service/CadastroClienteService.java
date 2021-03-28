package com.capitani.cliente.domain.service;

import com.capitani.cliente.domain.exception.ClienteNaoEncontradoException;
import com.capitani.cliente.domain.model.EnderecoCliente;
import com.capitani.cliente.domain.model.dto.EnderecoDTO;
import com.capitani.cliente.domain.repository.ClienteRepository;
import com.capitani.cliente.domain.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CadastroClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Transactional
	public Cliente salvar(Cliente cliente, EnderecoDTO enderecoDTO) {
		if(enderecoDTO != null) {
			EnderecoCliente enderecoCliente = new EnderecoCliente();
			enderecoCliente.setCidade(enderecoDTO.getCidade());
			enderecoCliente.setBairro(enderecoDTO.getBairro());
			enderecoCliente.setLogradouro(enderecoDTO.getComplemento());
			enderecoCliente.setNumero(enderecoDTO.getNumero());

			cliente.setEndereco(enderecoCliente);
			return clienteRepository.save(cliente);
		} else {
			return null;
		}
	}

	public Cliente buscarOuFalhar(String email) {
		return clienteRepository.findFirstClienteByEmailContaining(email)
			.orElseThrow(() -> new ClienteNaoEncontradoException());
	}
	
}
