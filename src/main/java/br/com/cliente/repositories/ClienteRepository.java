package br.com.cliente.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cliente.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
