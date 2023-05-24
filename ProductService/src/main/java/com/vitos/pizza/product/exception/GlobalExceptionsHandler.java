package com.vitos.pizza.product.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;


@ControllerAdvice
public class GlobalExceptionsHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException exception, WebRequest request ){
		ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(ResourceAlreadyFoundException.class)
	public ResponseEntity<?> handleResourceAlreadyExistsException(ResourceAlreadyFoundException exception, WebRequest request){
		ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));
        ResponseEntity<?> responseEntity = new ResponseEntity<Object>(errorDetails, HttpStatus.ALREADY_REPORTED);
		return responseEntity;
		
	}
	
	public ResponseEntity<?> handleGlobalException(ResourceNotFoundException exception, WebRequest request){
		ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));
			ResponseEntity<?> responseEntity1 = new ResponseEntity<Object>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
			return responseEntity1;
		
	}

}
