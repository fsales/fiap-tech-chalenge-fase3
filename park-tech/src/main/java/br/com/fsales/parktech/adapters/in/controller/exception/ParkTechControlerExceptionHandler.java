package br.com.fsales.parktech.adapters.in.controller.exception;

import br.com.fsales.parktech.adapters.in.controller.exception.response.ValidationErrorResponse;
import br.com.fsales.parktech.adapters.in.controller.exception.response.ViolationResponse;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
@Slf4j
public class ParkTechControlerExceptionHandler extends ResponseEntityExceptionHandler {

	private static void montarListaErro(ValidationErrorResponse error,
			ConstraintViolationException constraintViolationException) {
		constraintViolationException.getConstraintViolations().forEach(violation -> {
			error.getViolations()
				.add(new ViolationResponse(violation.getPropertyPath().toString(), violation.getMessage()));
		});
	}

	/**
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ValidationErrorResponse> handleGeneralExceptions(Exception ex) {
		var statusCode = HttpStatus.INTERNAL_SERVER_ERROR;
		log.error(ex.getMessage(), ex);

		ValidationErrorResponse error = new ValidationErrorResponse();
		error.violation(ViolationResponse.builder().message(ex.getMessage()).build());

		return new ResponseEntity<>(error, new HttpHeaders(), statusCode);
	}

	/**
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(RuntimeException.class)
	public final ResponseEntity<ValidationErrorResponse> handleRuntimeExceptions(RuntimeException ex) {

		var statusCode = HttpStatus.INTERNAL_SERVER_ERROR;

		ValidationErrorResponse error = new ValidationErrorResponse();

		error.violation(ViolationResponse.builder().message(ex.getMessage()).build());

		log.error(ex.getMessage(), ex);

		return new ResponseEntity<>(error, new HttpHeaders(), statusCode);
	}

	/**
	 * @param e
	 * @return
	 */
	@ExceptionHandler(ConstraintViolationException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	ValidationErrorResponse onConstraintValidationException(ConstraintViolationException e) {
		log.error(e.getMessage(), e);
		ValidationErrorResponse error = new ValidationErrorResponse();

		montarListaErro(error, e);

		return error;
	}

	/**
	 * @param e
	 * @param headers
	 * @param status
	 * @param request
	 * @return
	 */
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException e,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		var statusCode = HttpStatus.BAD_REQUEST;

		ValidationErrorResponse error = new ValidationErrorResponse();

		log.error(e.getMessage(), e);
		e.getBindingResult().getFieldErrors().forEach(fieldError -> {
			error.getViolations().add(new ViolationResponse(fieldError.getField(), fieldError.getDefaultMessage()));

		});

		return handleExceptionInternal(e, error, headers, statusCode, request);
	}

}
