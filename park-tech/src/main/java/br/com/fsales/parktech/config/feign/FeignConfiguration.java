package br.com.fsales.parktech.config.feign;

import java.util.concurrent.TimeUnit;

import feign.Retryer;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

@Import(FeignClientsConfiguration.class)
public class FeignConfiguration {

	@Bean
	public Retryer feignRetryer() {
		return new Retryer.Default(100, TimeUnit.SECONDS.toMillis(1), 2);
	}

}
