package br.com.fsales.parktech.infrastructure.configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfiguration {

    private final SwaggerConfigProperties swaggerConfigProperties;

    public OpenAPIConfiguration(SwaggerConfigProperties swaggerConfigProperties) {
        this.swaggerConfigProperties = swaggerConfigProperties;
    }

    @Bean
    public OpenAPI customOpenAPI(
    ) {
        var application = swaggerConfigProperties.getApplication();
        return new OpenAPI()
                .components(new Components())
                .info(
                        new Info()
                                .title(
                                        application.name()
                                )
                                .version(
                                        application.version()
                                )
                                .description(
                                        application.description()
                                )
                );
    }
}
