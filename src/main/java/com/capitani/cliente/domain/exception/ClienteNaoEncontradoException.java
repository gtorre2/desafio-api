package com.capitani.cliente.domain.exception;

public class ClienteNaoEncontradoException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 1L;

	public ClienteNaoEncontradoException(String mensagem) {
		super(mensagem);
	}

	public ClienteNaoEncontradoException() {
		this("Não existe um cadastro cliente para o email informado");
	}
}
