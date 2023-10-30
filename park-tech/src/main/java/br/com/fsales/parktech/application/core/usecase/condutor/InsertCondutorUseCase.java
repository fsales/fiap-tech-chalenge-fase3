package br.com.fsales.parktech.application.core.usecase.condutor;

import br.com.fsales.parktech.application.core.domain.Condutor;
import br.com.fsales.parktech.application.ports.in.condutor.InsertCondutorInputPort;
import br.com.fsales.parktech.application.ports.out.condutor.ConsultarEnderecoPorCepOutputPort;
import br.com.fsales.parktech.application.ports.out.condutor.InsertCondutorOutputPort;

public class InsertCondutorUseCase implements InsertCondutorInputPort {

	private final InsertCondutorOutputPort insertCondutorOutputPort;

	private final ConsultarEnderecoPorCepOutputPort consultarEnderecoPorCepOutputPort;

	public InsertCondutorUseCase(InsertCondutorOutputPort insertCondutorOutputPort,
			ConsultarEnderecoPorCepOutputPort consultarEnderecoPorCepOutputPort) {
		this.insertCondutorOutputPort = insertCondutorOutputPort;
		this.consultarEnderecoPorCepOutputPort = consultarEnderecoPorCepOutputPort;
	}

	@Override
	public Condutor insert(final Condutor condutor) {
		var endereco = consultarEnderecoPorCepOutputPort.consultaPorCep(condutor.getEndereco().getCep());
		if (endereco == null)
			throw new IllegalArgumentException("CEP inexistente.");

		condutor.getEndereco().setCidade(endereco.getCidade()).setUf(endereco.getUf());

		return insertCondutorOutputPort.insert(condutor);
	}

}
