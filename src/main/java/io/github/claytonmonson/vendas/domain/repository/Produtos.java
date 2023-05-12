package io.github.claytonmonson.vendas.domain.repository;

import io.github.claytonmonson.vendas.domain.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Produtos extends JpaRepository<Produto, Integer> {
}
