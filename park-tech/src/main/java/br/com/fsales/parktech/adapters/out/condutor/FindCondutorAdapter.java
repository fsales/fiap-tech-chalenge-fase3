package br.com.fsales.parktech.adapters.out.condutor;

import br.com.fsales.parktech.adapters.out.repository.CondutorRepository;
import br.com.fsales.parktech.adapters.out.repository.mapper.CondutorEntityMapper;
import br.com.fsales.parktech.application.ports.out.FindCondutorOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor

@Component
public class FindCondutorAdapter implements FindCondutorOutputPort {

	private final CondutorRepository condutorRepository;

	private final CondutorEntityMapper condutorEntityMapper;

	public void ss(int pageNumber, int pageSize) {

		Pageable paginacao = PageRequest.of(pageNumber, pageSize);
		var page = condutorRepository.findAll(paginacao);

		var lista = page.getContent();
		var total = page.getTotalElements();

		Page p = new PageImpl(lista, PageRequest.of(pageNumber, pageSize), total);

		System.out.println(p);
	}

}
