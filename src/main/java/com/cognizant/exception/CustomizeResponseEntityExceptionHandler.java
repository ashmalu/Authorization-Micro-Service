package com.cognizant.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestController
@ControllerAdvice

public class CustomizeResponseEntityExceptionHandler 
extends ResponseEntityExceptionHandler 
{

	public final ResponseEntity<Object> userNotFoundExceptions
	(Exception ex,WebRequest request)
	{
	ExceptionResponse exp=	new ExceptionResponse(new Date(),ex.getMessage(),request.getDescription(false));
		return new ResponseEntity(exp,HttpStatus.NOT_FOUND);
	}

	
}