package br.com.fsales.parktech;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes = TestMongoConfig.class)
class ParkTechApplicationTests {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Test
	void contextLoads() {
	}

}
