package io.github.claytonmonson.vendas.rest.controller;

import io.github.claytonmonson.vendas.domain.entity.Produto;
import io.github.claytonmonson.vendas.domain.repository.Produtos;
import jakarta.validation.Valid;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    private Produtos produtos;

    public ProdutoController(Produtos produtos) {
        this.produtos = produtos;
    }

    @GetMapping("{id}")
    public Produto getProdutoById(@PathVariable("id") Integer id ) {
        return produtos
                .findById(id)
                .orElseThrow( () -> new ResponseStatusException( HttpStatus.NOT_FOUND, "Produto não encontrado" ));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Produto save(@RequestBody @Valid Produto produto ) {
        return produtos.save(produto);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete( @PathVariable("id") Integer id) {
        produtos.findById(id)
                .map(produto -> {
                    produtos.delete(produto);
                    return produto;
                })
                .orElseThrow(() -> new ResponseStatusException( HttpStatus.NOT_FOUND, "Produto não encontrado" ));
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update( @PathVariable("id") Integer id, @RequestBody @Valid Produto produto) {

        produtos
                .findById(id)
                .map(produtoExistente -> {
                    produto.setId(produtoExistente.getId());
                    produtos.save(produto);
                    return produtoExistente;
                })
                .orElseThrow(() -> new ResponseStatusException( HttpStatus.NOT_FOUND, "Produto não encontrado" ));

    }

    @GetMapping
    public List<Produto> find(Produto filtro ) {
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example example = Example.of(filtro, matcher);

        return produtos.findAll(example);
    }
}
