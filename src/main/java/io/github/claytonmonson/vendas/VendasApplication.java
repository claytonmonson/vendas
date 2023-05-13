package io.github.claytonmonson.vendas;

import io.github.claytonmonson.vendas.domain.entity.Cliente;
import io.github.claytonmonson.vendas.domain.entity.Pedido;
import io.github.claytonmonson.vendas.domain.repository.Clientes;
import io.github.claytonmonson.vendas.domain.repository.Pedidos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDate;

@SpringBootApplication
public class VendasApplication {

	@Bean
	public CommandLineRunner init(
			@Autowired Clientes clientes,
			@Autowired Pedidos pedidos) {
		return args -> {

			System.out.println("Salvando clientes");
			Cliente fulano = new Cliente("Fulano") ;
			clientes.save(fulano);

			Pedido p = new Pedido();
			p.setCliente(fulano);
			p.setDataPedido(LocalDate.now());
			p.setTotal(BigDecimal.valueOf(100));

			pedidos.save(p);

			pedidos.findByCliente(fulano).forEach(System.out::println);


//			Cliente cliente = clientes.findClienteFetchPedidos(fulano.getId());
//			System.out.println(cliente);
//			System.out.println(cliente.getPedidos());

//			List<Cliente> result = clientes.encontrarPorNome("Douglas");
//			result.forEach(System.out::println);

//			boolean existe = clientes.existsByNome("Douglas");
//			System.out.println("Existe um cliente com o nome Douglas ? " + existe );

//			List<Cliente> result = clientes.findByNomeLike("Douglas");
//			result.forEach(System.out::println);

		};
	}

	public static void main(String[] args) {

		SpringApplication.run(VendasApplication.class, args);

	}

}
