package br.com.fsales.parktech.infrastructure.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("application.swagger")
@Data
public class SwaggerConfigProperties {

    @NestedConfigurationProperty
    private Application application;

    public record Application(
            String name,

            String description,

            String version
    ) {
    }
}
