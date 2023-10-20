package br.com.fsales.parktech.application.ports.out;

import br.com.fsales.parktech.application.core.domain.Endereco;

public interface ConsultarEnderecoPorCepOutputPort {

	/**
	 * @param cep
	 * @return
	 */
	Endereco consultaPorCep(final String cep);

}
