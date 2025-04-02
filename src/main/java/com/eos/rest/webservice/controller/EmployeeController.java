package com.eos.rest.webservice.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eos.rest.webservice.dto.EmployeeDetailsDto;
import com.eos.rest.webservice.dto.ValidationErrorResponseDto;
import com.eos.rest.webservice.entity.EmployeeDetailsEnitiy;
import com.eos.rest.webservice.error.ErrorResponse;
import com.eos.rest.webservice.exception.EmployeeDetailsNotFoundException;
import com.eos.rest.webservice.service.EmployeeDetailsService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
@RequestMapping("/api/Employee")
public class EmployeeController {

	
	private  final EmployeeDetailsService employeeDetailsService ;
	
	
	public EmployeeController(EmployeeDetailsService employeeDetailsService) {
		this.employeeDetailsService = employeeDetailsService;
	}

	@PostMapping("/create")
	public ResponseEntity<?> createEmployeeDetails(@RequestBody @Valid EmployeeDetailsEnitiy entity , BindingResult bindingResult) {
		log.info("Request for Employee Details Enitiy recived {}",entity);
		if(bindingResult.hasErrors()) {
			log.warn("Validation  error occurred for enitity {} ",entity);
			Map<String, String> errorMap = new HashMap<>();
			for (FieldError error : bindingResult.getFieldErrors()) {
				errorMap.put(error.getField(), error.getDefaultMessage());
				log.error("Field error: {} - {}", error.getField(), error.getDefaultMessage());
				log.error("Field error: {} - {}", error.getField(), error.getDefaultMessage());
			}
			
			ValidationErrorResponseDto errorResponse = new ValidationErrorResponseDto(
	                "Validation failed", errorMap
	            );
			 return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
		}
		log.info("No validation errors, proceeding to create referral employee");
		EmployeeDetailsDto response = employeeDetailsService.createEmployee(entity);
		log.info("Employee Details created successfully: {} ",response);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping(value = "/search/{empId}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> searchEmployeeDetailsByEmpId(@PathVariable("empId") String empId) {
		log.info("Employee id has recived :{} ",empId);
		EmployeeDetailsDto response;
		try {
			response = employeeDetailsService.searchEmployeeDetails(empId);
			log.info("Successfully fetched details for Employee ID: {}", empId);
		}catch (EmployeeDetailsNotFoundException ex) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new 
					ErrorResponse (ex.getMessage() , HttpStatus.NOT_FOUND.value()));
		}		
		return ResponseEntity.ok(response);
	}
	
	
}
