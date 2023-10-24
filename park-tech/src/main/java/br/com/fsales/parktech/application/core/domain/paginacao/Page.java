package br.com.fsales.parktech.application.core.domain.paginacao;

import br.com.fsales.parktech.application.core.domain.funcionalinterface.Mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public record Page<T>(List<T> list, long totalElements) {

	public <R> Page<R> map(Mapper<? super T, ? extends R> mapper) {
		List<R> mappedList = list == null ? new ArrayList<>()
				: list.stream().map(mapper::apply).collect(Collectors.toList());
		return new Page<>(mappedList, totalElements);
	}
}
