package com.eos.rest.webservice.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class MobileNoExistsException extends RuntimeException {

	public MobileNoExistsException(String message) {
		super(message);
	}
	
	
}
