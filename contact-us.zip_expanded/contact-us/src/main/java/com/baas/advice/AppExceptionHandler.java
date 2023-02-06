package com.baas.advice;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.baas.ThrowException.ClientNotFoundException;

@RestControllerAdvice
public class AppExceptionHandler {

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String,String> handleInvalidArgument(MethodArgumentNotValidException e){
		Map<String,String> errorMap = new HashMap<>();
		e.getBindingResult().getFieldErrors().forEach(error->{
			errorMap.put(error.getField(), error.getDefaultMessage());
		});
		return errorMap;
	}


	//TODO: Este deberia ser 404 NOT FOUND. Eso es lo deberia de representar ClientNotFoundException.
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(ClientNotFoundException.class)
	public Map<String,String> handleBusinessException(ClientNotFoundException e){
		Map<String,String> errorMap = new HashMap<>();
		errorMap.put("errorMessage", e.getMessage());
		return errorMap;
	}
}
