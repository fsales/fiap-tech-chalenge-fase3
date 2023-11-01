package br.com.fsales.parktech.infrastructure.configuration;

import java.text.SimpleDateFormat;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.core.jackson.ModelResolver;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

@Configuration
public class OpenAPIConfiguration {

	private final SwaggerConfigProperties swaggerConfigProperties;

	public OpenAPIConfiguration(SwaggerConfigProperties swaggerConfigProperties) {
		this.swaggerConfigProperties = swaggerConfigProperties;
	}

	@Bean
	public OpenAPI customOpenAPI() {
		var application = swaggerConfigProperties.getApplication();
		return new OpenAPI().components(new Components())
			.info(new Info().title(application.name())
				.version(application.version())
				.description(application.description()));
	}

	@Bean
	public ObjectMapper customObjectMapper() {
		Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
		builder.dateFormat(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")); // Define o
																			// formato de
																			// data e hora

		return builder.build();
	}

	@Bean
	public ModelResolver modelResolver(ObjectMapper objectMapper) {
		return new ModelResolver(objectMapper);
	}
}
