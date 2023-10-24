package br.com.fsales.parktech.adapters.out.endereco;

import br.com.fsales.parktech.adapters.out.client.ConsultarEnderecoPorCepClient;
import br.com.fsales.parktech.adapters.out.repository.mapper.EnderecoResponseMapper;
import br.com.fsales.parktech.application.core.domain.Endereco;
import br.com.fsales.parktech.application.ports.out.condutor.ConsultarEnderecoPorCepOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor

@Component
public class ConsultarEnderecoPorCepAdapter implements ConsultarEnderecoPorCepOutputPort {

	private final ConsultarEnderecoPorCepClient consultarEnderecoPorCepClient;

	private final EnderecoResponseMapper enderecoResponseMapper;

	@Override
	public Endereco consultaPorCep(String cep) {
		var enderecoResponse = consultarEnderecoPorCepClient.consultaPorCep(cep);
		return enderecoResponseMapper.toEndereco(enderecoResponse);
	}

}
