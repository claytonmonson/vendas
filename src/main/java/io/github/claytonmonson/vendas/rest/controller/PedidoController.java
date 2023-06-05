package io.github.claytonmonson.vendas.rest.controller;

import io.github.claytonmonson.vendas.domain.entity.Pedido;
import io.github.claytonmonson.vendas.rest.dto.PedidoDTO;
import io.github.claytonmonson.vendas.service.PedidoService;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    private PedidoService service;

    public PedidoController(PedidoService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public Integer save(@RequestBody PedidoDTO dto) {
        Pedido pedido = service.salvar(dto);
        return pedido.getId();
    }
}
