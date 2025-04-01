package com.eos.rest.webservice.exception;

import lombok.NoArgsConstructor;


@NoArgsConstructor
public class EmployeeDetailsNotFoundException extends RuntimeException {

	
	
	public EmployeeDetailsNotFoundException(String message) {
        super(message);  // Pass the message to RuntimeException's constructor
    }
}
