package com.example.exercicio1;

import ch.qos.logback.classic.Logger;
import com.example.exercicio1.model.User;
import com.example.exercicio1.repository.UserRepository;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Exercicio1Application {

	private final Logger LOGGER = (Logger) LoggerFactory.getLogger(Exercicio1Application.class);

	public static void main(String[] args) {

		SpringApplication.run(Exercicio1Application.class, args);
	}

	@Bean
	public CommandLineRunner loadDB(UserRepository userRepository) throws Exception{
		return(args) -> {
			LOGGER.info("Carregando a base de dados...");

			var user1 = new User();
			user1.setName("Frodo Bolseiro");
			user1.setEmail("frodo.bolsao@email.com");

			var user2 = new User();
			user1.setName("Samwise Gamgee");
			user1.setEmail("sam@email.com");

			userRepository.save(user1);
			userRepository.save(user2);

			userRepository.findAll().forEach(
					(u) -> LOGGER.info("User criado com sucesso!")
			);

			LOGGER.info("A base de dados esta carregada!");
		};
	}

}
