package com.eos.rest.webservice.service;

import com.eos.rest.webservice.dto.EmployeeDetailsDto;
import com.eos.rest.webservice.entity.EmployeeDetailsEnitiy;

public interface EmployeeDetailsService {
	
	EmployeeDetailsDto createEmployee(EmployeeDetailsEnitiy entity);

	EmployeeDetailsDto searchEmployeeDetails(String empId);

}
