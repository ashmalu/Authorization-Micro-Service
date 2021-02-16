package com.cognizant.exception;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionResponse {

	private Date datestamp;
	private String message;
	private String details;
	
	
}
