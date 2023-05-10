package io.github.claytonmonson.vendas.domain.repository;

import io.github.claytonmonson.vendas.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Clientes extends JpaRepository<Cliente, Integer> {

    List<Cliente> findByNomeLike(String nome);

    boolean existsByNome(String nome);

}
