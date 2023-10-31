package br.com.fsales.parktech.config;

import br.com.fsales.parktech.adapters.in.controller.ParktechResource;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GroupedOpenApiConfig {

	private static final String PATH_POSFIXO = "/**";

	@Bean
	public GroupedOpenApi actuatorApi() {

		String[] paths = { String.format("%s%s", ParktechResource.ACTUATOR, PATH_POSFIXO) };
		return GroupedOpenApi.builder().group("Actuator").pathsToMatch(paths).build();
	}

	@Bean
	public GroupedOpenApi condutorOpenApi() {
		String[] paths = { String.format("%s%s", ParktechResource.CONDUTOR, PATH_POSFIXO) };
		return GroupedOpenApi.builder().group("Condutores").pathsToMatch(paths).build();
	}

	@Bean
	public GroupedOpenApi estacionamentoOpenApi() {
		String[] paths = { String.format("%s%s", ParktechResource.ESTACIONAMENTO, PATH_POSFIXO) };
		return GroupedOpenApi.builder().group("estacionamentos").pathsToMatch(paths).build();
	}


	@Bean
	public GroupedOpenApi veiculoOpenApi() {
		String[] paths = { String.format("%s%s", ParktechResource.VEICULO, PATH_POSFIXO) };
		return GroupedOpenApi.builder().group("Veiculos").pathsToMatch(paths).build();
	}
}
