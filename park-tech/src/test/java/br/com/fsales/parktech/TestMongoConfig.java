package br.com.fsales.parktech;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
@Profile("test")
public class TestMongoConfig {

	@Bean
	public MongoTemplate mongoTemplate() {
		// Crie um mock do MongoTemplate usando o Mockito
		MongoTemplate mongoTemplate = Mockito.mock(MongoTemplate.class);

		// Especifique o comportamento do mock, se necessário
		// Mockito.when(mongoTemplate.find(...)).thenReturn(...);

		return mongoTemplate;
	}

}