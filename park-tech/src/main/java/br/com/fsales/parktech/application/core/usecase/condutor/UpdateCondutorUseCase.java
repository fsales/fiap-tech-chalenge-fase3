package br.com.fsales.parktech.application.core.usecase.condutor;

import br.com.fsales.parktech.application.core.domain.Condutor;
import br.com.fsales.parktech.application.ports.in.UpdateCondutorInputPort;
import br.com.fsales.parktech.application.ports.out.ConsultarEnderecoPorCepOutputPort;
import br.com.fsales.parktech.application.ports.out.FindCondutorByIdOutputPort;
import br.com.fsales.parktech.application.ports.out.UpdateCondutorOutputPort;

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
