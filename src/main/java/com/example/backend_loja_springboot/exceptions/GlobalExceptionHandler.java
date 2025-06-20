package com.example.backend_loja_springboot.exceptions;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Object> HandleResourceNotFound(ResourceNotFoundException e){
		Map<String,Object> body = new LinkedHashMap<>();
		body.put("timestamp", LocalDateTime.now());
		body.put("status", HttpStatus.NOT_FOUND.value());
		body.put("error", "Recurso não encontrado");
		body.put("message", e.getMessage());
		return new ResponseEntity<>(body,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> HandleGenericException(Exception e){
		Map<String,Object> body = new LinkedHashMap<>();
		body.put("timestamp", LocalDateTime.now());
		body.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
		body.put("error", "Erro interno do servidor!");
		body.put("message", e.getMessage());
		return new ResponseEntity<>(body,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
