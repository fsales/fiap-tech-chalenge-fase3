package br.com.fsales.parktech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@EnableMongoAuditing
@SpringBootApplication
public class ParkTechApplication {

	public static void main(String[] args) {

		SpringApplication.run(ParkTechApplication.class, args);
	}

}
