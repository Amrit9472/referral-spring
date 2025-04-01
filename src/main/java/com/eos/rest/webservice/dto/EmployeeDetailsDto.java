package com.eos.rest.webservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDetailsDto {

	
	private String employeeId;	
	private String email;
	private String name;
	
}
