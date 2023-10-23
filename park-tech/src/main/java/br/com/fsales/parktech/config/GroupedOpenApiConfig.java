package br.com.fsales.parktech.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GroupedOpenApiConfig {

	public static final String ACTUATOR = "actuator";

	public static final String CONDUTORES = "condutores";

	@Bean
	public GroupedOpenApi actuatorApi() {
		String[] paths = { "/" + ACTUATOR + "/**" };
		return GroupedOpenApi.builder().group("Actuator").pathsToMatch(paths).build();
	}

	@Bean
	public GroupedOpenApi petOpenApi() {
		String paths[] = { "/" + CONDUTORES + "/**" };
		return GroupedOpenApi.builder().group("Condutores").pathsToMatch(paths).build();
	}

}
