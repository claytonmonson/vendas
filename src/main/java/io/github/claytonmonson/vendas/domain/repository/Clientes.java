package io.github.claytonmonson.vendas.domain.repository;

import io.github.claytonmonson.vendas.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Clientes extends JpaRepository<Cliente, Integer> {
}
