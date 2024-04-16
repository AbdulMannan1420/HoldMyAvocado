package nl.hu.avocado;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AvocadoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AvocadoApplication.class, args);
	}
	@Bean
	public CommandLineRunner run() {
		return args -> {
		//hier komt data te staan die je wilt toevoegen aan de database
		};
	}

}
