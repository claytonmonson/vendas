package io.github.claytonmonson.vendas.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="PRODUTO")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Integer id;

    @Column(name="descricao", length=100)
    @NotEmpty(message = "Descrição é obrigatória")
    private String descricao;

    @Column(name="preco_unitario", precision = 20, scale = 2)
    @NotNull(message = "Preço é obrigatório")
    private BigDecimal preco;

}
