package io.github.claytonmonson.vendas.rest.controller;

import io.github.claytonmonson.vendas.domain.entity.Cliente;
import io.github.claytonmonson.vendas.domain.repository.Clientes;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class ClienteController {

    private Clientes clientes;

    public ClienteController( Clientes clientes ) {
        this.clientes = clientes;
    }

    @GetMapping("/api/clientes/{id}")
    @ResponseBody
    public ResponseEntity getClienteById(@PathVariable("id") Integer id ) {
        Optional<Cliente> cliente = clientes.findById(id);

        if(cliente.isPresent()) {
            return ResponseEntity.ok(cliente.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/api/clientes")
    @ResponseBody
    public ResponseEntity save( @RequestBody Cliente cliente ) {
        Cliente clienteSalvo = clientes.save(cliente);
        return ResponseEntity.ok(clienteSalvo);
    }

    @DeleteMapping("api/clientes/{id}")
    public ResponseEntity delete( @PathVariable("id") Integer id) {
        Optional<Cliente> cliente = clientes.findById(id);

        if(cliente.isPresent()) {
            clientes.delete(cliente.get());
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/api/clientes/{id}")
    @ResponseBody
    public ResponseEntity update( @PathVariable("id") Integer id, @RequestBody Cliente cliente) {

        return clientes
                .findById(id)
                .map(clienteExistente -> {
                    cliente.setId(clienteExistente.getId());
                    clientes.save(cliente);
                    return ResponseEntity.noContent().build();
                }).orElseGet( () -> ResponseEntity.notFound().build());
    }

}