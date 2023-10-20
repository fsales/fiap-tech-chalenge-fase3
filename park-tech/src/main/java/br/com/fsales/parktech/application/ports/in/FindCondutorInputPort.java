package br.com.fsales.parktech.application.ports.in;

import br.com.fsales.parktech.adapters.in.controller.condutor.request.ListarCondutorRequest;
import org.springframework.data.domain.Pageable;

public interface FindCondutorInputPort {

	void consultaPaginada(ListarCondutorRequest condutorRequest, Pageable pageable);

}
