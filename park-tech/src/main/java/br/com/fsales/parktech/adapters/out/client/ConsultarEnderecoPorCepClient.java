package br.com.fsales.parktech.adapters.out.client;

import br.com.fsales.parktech.adapters.out.client.response.EnderecoResponse;
import br.com.fsales.parktech.config.feign.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ceps", primary = false, contextId = "enderecoClient", url = "${application.client.endereco.host}",
		configuration = FeignConfiguration.class)
public interface ConsultarEnderecoPorCepClient {

	@GetMapping(value = "/{cep}/json/", consumes = MediaType.APPLICATION_JSON_VALUE)
	EnderecoResponse consultaPorCep(@PathVariable("cep") String cep);

}
