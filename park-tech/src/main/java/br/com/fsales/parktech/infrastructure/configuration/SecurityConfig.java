package br.com.fsales.parktech.infrastructure.configuration;

import br.com.fsales.parktech.adapters.in.controller.ParktechResource;
import br.com.fsales.parktech.infrastructure.properties.ParktechProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(authConfig -> {
			authConfig.requestMatchers("/").authenticated();
			authConfig.requestMatchers(ParktechResource.CONDUTOR + "/**").authenticated();
			authConfig.requestMatchers(ParktechResource.ESTACIONAMENTO + "/**").authenticated();
			authConfig.requestMatchers(ParktechResource.VEICULO + "/**").authenticated();
			authConfig.requestMatchers(ParktechResource.ACTUATOR + "/**").permitAll();
			authConfig.requestMatchers("/v3/api-docs/**", "/swagger-ui/**", "/swagger-ui.html").permitAll();
			authConfig.anyRequest().permitAll();
		})
			.csrf(AbstractHttpConfigurer::disable)
			.cors(AbstractHttpConfigurer::disable)
			// .formLogin(Customizer.withDefaults()) // Login with browser and Form
			.httpBasic(Customizer.withDefaults()); // Login with postman and Basic Auth
		return http.build();
	}

	@Bean
	public InMemoryUserDetailsManager userDetailsService(ParktechProperties parktechProperties) {
		var userProperties = parktechProperties.getSecurity().user();

		UserDetails user = User.withUsername(userProperties.name())
			.password(encoder().encode(userProperties.password()))
			.roles(userProperties.roles())
			.build();
		return new InMemoryUserDetailsManager(user);
	}

	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}

}
