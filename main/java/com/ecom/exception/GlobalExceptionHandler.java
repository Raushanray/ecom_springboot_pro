package com.ecom.exception;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

import javax.validation.UnexpectedTypeException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ecom.payload.ApiResonse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResonse> handleResourceNotFoundException(ResourceNotFoundException ex) {
		ApiResonse apiResonse = new ApiResonse(ex.getMessage(), false);
		return new ResponseEntity<ApiResonse>(apiResonse, HttpStatus.NOT_FOUND);

	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
		Map<String, String> map = new HashMap<>();
		// put the messages to map
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			// error:
			String message = error.getDefaultMessage();
			String fieldName = ((FieldError) error).getField();
			map.put(fieldName, message);

		});

		return new ResponseEntity<Map<String, String>>(map, HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(SQLIntegrityConstraintViolationException.class)
	public ResponseEntity<ApiResonse> handleSQLIntegrityException(SQLIntegrityConstraintViolationException ex) {
		ApiResonse apiResonse = new ApiResonse(ex.getMessage(), false);
		return new ResponseEntity<ApiResonse>(apiResonse, HttpStatus.BAD_REQUEST);

	}

	

	@ExceptionHandler(BadUserLoginDetailException.class)
	public ResponseEntity<ApiResonse> handleBadUserLoginDetailException(BadUserLoginDetailException ex) {
		ApiResonse apiResonse = new ApiResonse(ex.getMessage(), false);
		return new ResponseEntity<ApiResonse>(apiResonse, HttpStatus.BAD_REQUEST);

	}
	
	
	
//	@ExceptionHandler(SQLIntegrityConstraintViolationException.class)
//	public ResponseEntity<Map<String, String>> handleMethodUnique(SQLIntegrityConstraintViolationException ex) {
//		Map<String, String> map = new HashMap<>();
//		
//		map.put("Email duplicate", "Email already exist");
//
//		return new ResponseEntity<Map<String, String>>(map, HttpStatus.BAD_REQUEST);
//	}
}
