package com.eos.rest.webservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.eos.rest.webservice.error.ErrorResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(EmployeeDetailsNotFoundException.class)
    @ResponseBody
	public ResponseEntity<ErrorResponse> handleEmployeeDetailsNotFound(EmployeeDetailsNotFoundException ex){
		 log.error("Exception occurred: {}", ex.getMessage());
		ErrorResponse  errorResponse = new ErrorResponse();
		errorResponse.setMessage(ex.getMessage());
		errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<>(errorResponse , HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(MobileNoExistsException.class)
	public ResponseEntity<ErrorResponse> handleUserMobileNoExistFound(MobileNoExistsException ex){
		ErrorResponse  errorResponse = new ErrorResponse();
		errorResponse.setMessage(ex.getMessage());
		errorResponse.setStatus(HttpStatus.FOUND.value());
		return new ResponseEntity<>(errorResponse,HttpStatus.FOUND);
	}
	@ExceptionHandler(EmailExistsException.class)
	public ResponseEntity<ErrorResponse> handleUserEmailDetailsFound(EmailExistsException ex){
		ErrorResponse  errorResponse = new ErrorResponse();
		errorResponse.setMessage(ex.getMessage());
		errorResponse.setStatus(HttpStatus.FOUND.value());
		return new ResponseEntity<>(errorResponse,HttpStatus.FOUND);
	}
}
