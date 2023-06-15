package io.github.claytonmonson.vendas.service;

import io.github.claytonmonson.vendas.domain.entity.Pedido;
import io.github.claytonmonson.vendas.rest.dto.PedidoDTO;

import java.util.Optional;

public interface PedidoService {
    Pedido salvar(PedidoDTO dto);

    Optional<Pedido> obterPedidoCompleto(Integer id);
}
