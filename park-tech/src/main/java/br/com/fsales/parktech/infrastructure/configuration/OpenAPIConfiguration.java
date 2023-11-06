package br.com.fsales.parktech.infrastructure.configuration;

import java.text.SimpleDateFormat;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.core.jackson.ModelResolver;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

@Configuration
@SecurityScheme(type = SecuritySchemeType.HTTP, name = "basicAuth", in = SecuritySchemeIn.COOKIE, scheme = "basic")
public class OpenAPIConfiguration {

	private static final String SCHEME_NAME = "basicAuth";

	private static final String SCHEME = "basic";

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
				.description(application.description()))
			.components(new Components().addSecuritySchemes(SCHEME_NAME, createSecurityScheme()))
			.addSecurityItem(new SecurityRequirement().addList(SCHEME_NAME));
	}

	private io.swagger.v3.oas.models.security.SecurityScheme createSecurityScheme() {
		return new io.swagger.v3.oas.models.security.SecurityScheme().name(SCHEME_NAME)
			.type(io.swagger.v3.oas.models.security.SecurityScheme.Type.HTTP)
			.scheme(SCHEME);
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
