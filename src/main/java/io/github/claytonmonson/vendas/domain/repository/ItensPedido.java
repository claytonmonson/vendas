package io.github.claytonmonson.vendas.domain.repository;

import io.github.claytonmonson.vendas.domain.entity.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItensPedido extends JpaRepository<ItemPedido, Integer> {
}
