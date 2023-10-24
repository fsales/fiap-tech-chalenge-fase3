package br.com.fsales.parktech.application.core.usecase.condutor;

import br.com.fsales.parktech.application.core.domain.Condutor;
import br.com.fsales.parktech.application.ports.in.condutor.UpdateCondutorInputPort;
import br.com.fsales.parktech.application.ports.out.condutor.ConsultarEnderecoPorCepOutputPort;
import br.com.fsales.parktech.application.ports.out.condutor.FindCondutorByIdOutputPort;
import br.com.fsales.parktech.application.ports.out.condutor.UpdateCondutorOutputPort;

public class UpdateCondutorUseCase implements UpdateCondutorInputPort {

	private final UpdateCondutorOutputPort updateCondutorOutputPort;

	private final FindCondutorByIdOutputPort findCondutorByIdOutputPort;

	private final ConsultarEnderecoPorCepOutputPort consultarEnderecoPorCepOutputPort;

	public UpdateCondutorUseCase(UpdateCondutorOutputPort updateCondutorOutputPort,
			FindCondutorByIdOutputPort findCondutorByIdOutputPort,
			ConsultarEnderecoPorCepOutputPort consultarEnderecoPorCepOutputPort) {
		this.updateCondutorOutputPort = updateCondutorOutputPort;
		this.findCondutorByIdOutputPort = findCondutorByIdOutputPort;
		this.consultarEnderecoPorCepOutputPort = consultarEnderecoPorCepOutputPort;
	}

	@Override
	public Condutor update(Condutor condutor) {
		findCondutorByIdOutputPort.find(condutor.id())
			.orElseThrow(() -> new RuntimeException("Condutor não encontrado."));

		var endereco = consultarEnderecoPorCepOutputPort.consultaPorCep(condutor.endereco().cep());
		if (endereco == null)
			throw new IllegalArgumentException("CEP inexistente.");

		condutor.endereco().setCidade(endereco.cidade()).setUf(endereco.uf());

		return updateCondutorOutputPort.update(condutor);
	}

}
