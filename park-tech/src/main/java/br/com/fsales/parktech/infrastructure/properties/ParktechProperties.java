package br.com.fsales.parktech.infrastructure.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("spring")
@Data
public class ParktechProperties {

	@NestedConfigurationProperty
	private Security security;

	public record Security(@NestedConfigurationProperty User user) {

		public record User(String name, String password, String... roles) {

		}

	}
}
