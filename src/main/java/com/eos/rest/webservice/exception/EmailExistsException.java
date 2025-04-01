package com.eos.rest.webservice.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class EmailExistsException extends RuntimeException {

	public EmailExistsException(String message) {
		super(message);
	}

	
  
	
	
}
