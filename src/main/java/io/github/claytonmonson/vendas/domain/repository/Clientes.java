package io.github.claytonmonson.vendas.domain.repository;

import io.github.claytonmonson.vendas.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Clientes extends JpaRepository<Cliente, Integer> {

//    @Query(value = " Select c From Cliente c Where c.nome like :nome ")
//    List<Cliente> encontrarPorNome(@Param("nome") String nome);

    List<Cliente> findByNomeLike(String nome);
    boolean existsByNome(String nome);

}
