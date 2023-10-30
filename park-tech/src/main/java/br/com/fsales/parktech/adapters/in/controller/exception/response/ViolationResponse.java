package br.com.fsales.parktech.adapters.in.controller.exception.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;

@Builder
public record ViolationResponse(@JsonInclude(JsonInclude.Include.NON_NULL) String fieldName,

		@JsonInclude(JsonInclude.Include.NON_NULL) String message) {

}
