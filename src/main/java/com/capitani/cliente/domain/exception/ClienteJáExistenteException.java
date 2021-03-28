package com.capitani.cliente.domain.exception;

public class ClienteJáExistenteException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 1L;

	public ClienteJáExistenteException(String mensagem) {
		super(mensagem);
	}

	public ClienteJáExistenteException() {
		this("Já existe um cadastro cliente para o email e cpf informados");
	}
}
