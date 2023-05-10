package io.github.claytonmonson.vendas;

import io.github.claytonmonson.vendas.domain.entity.Cliente;
import io.github.claytonmonson.vendas.domain.repository.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class VendasApplication {

	@Bean
	public CommandLineRunner init(@Autowired Clientes clientes) {
		return args -> {

			System.out.println("Salvando clientes");
			clientes.save(new Cliente("Fulano"));
			clientes.save(new Cliente("Outro Cliente"));

			boolean existe = clientes.existsByNome("Douglas");
			System.out.println("Existe um cliente com o nome Douglas ? " + existe );

		};
	}

	public static void main(String[] args) {

		SpringApplication.run(VendasApplication.class, args);

	}

}
