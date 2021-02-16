package com.cognizant.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ExcetptionRaise extends RuntimeException {

	public ExcetptionRaise(String arg)
	{
		super(arg);
	}
}
