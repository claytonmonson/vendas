package io.github.claytonmonson.vendas.service;

import io.github.claytonmonson.vendas.domain.entity.Pedido;
import io.github.claytonmonson.vendas.rest.dto.PedidoDTO;

public interface PedidoService {
    Pedido salvar(PedidoDTO dto);
}
