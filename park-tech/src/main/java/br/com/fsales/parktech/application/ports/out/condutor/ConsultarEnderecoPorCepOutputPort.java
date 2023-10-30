package br.com.fsales.parktech.application.ports.out.condutor;

import br.com.fsales.parktech.application.core.domain.Endereco;

public interface ConsultarEnderecoPorCepOutputPort {

	/**
	 * @param cep
	 * @return
	 */
	Endereco consultaPorCep(final String cep);

}
