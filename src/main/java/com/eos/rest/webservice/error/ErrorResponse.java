package com.eos.rest.webservice.error;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {
	    @JsonProperty("message")
	    private String message;
	    
	    @JsonProperty("status")
	    private int status;
}
