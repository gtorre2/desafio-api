package com.capitani.cliente.domain.repository;

import com.capitani.cliente.domain.model.Cliente;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepository
		extends CustomJpaRepository<Cliente, Long>,
		JpaSpecificationExecutor<Cliente> {

	List<Cliente> findAll();

	Optional<Cliente> findFirstClienteByEmailContaining(String email);

    Optional<Cliente> findFirstClienteByEmailAndCpfContaining(String email, String cpf);

}
