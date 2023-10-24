package br.com.fsales.parktech.adapters.in.controller.exception.response;

import lombok.Value;

import java.util.ArrayList;
import java.util.List;

@Value
public class ValidationErrorResponse {

	private final List<ViolationResponse> violations = new ArrayList<>();

	public void violation(ViolationResponse violation) {

		this.violations.add(violation);
	}

	public void violation(List<ViolationResponse> violations) {
		if (violations != null)
			this.violations.addAll(violations);
	}

}
