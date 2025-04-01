package com.eos.rest.webservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eos.rest.webservice.dto.ReferralEmployeeDto;
import com.eos.rest.webservice.dto.ValidationErrorResponseDto;
import com.eos.rest.webservice.entity.ReferralEnitity;
import com.eos.rest.webservice.serviceImpl.ReferralUserServiceImpl;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Slf4j
@RestController
@RequestMapping("api/referral")
public class UserReferralController {

	
	private ReferralUserServiceImpl referralUserService;
		
	public UserReferralController(ReferralUserServiceImpl referralUserService) {
		super();
		this.referralUserService = referralUserService;
	}

	@PostMapping("/user")
	public ResponseEntity<?> ReferralUser(@RequestBody @Valid ReferralEnitity entity ,BindingResult bindingResult) {
		log.info("Referral user creation request received for {}",entity);
		if(bindingResult.hasErrors()) {
        log.warn("validation errors occurred for enitity {} ",entity);
			Map<String,String> errorMap = new HashMap<>();
			for (FieldError error : bindingResult.getFieldErrors()) {
				errorMap.put(error.getField(), error.getDefaultMessage());
				log.error("Field error: {} - {}", error.getField(), error.getDefaultMessage());
            }
			 ValidationErrorResponseDto errorResponse = new ValidationErrorResponseDto(
		                "Validation failed", errorMap
		            );
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
		log.info("No validation errors, proceeding to create referral employee");
		ReferralEmployeeDto response = referralUserService.createReferralEmployee(entity);
		log.info("Referral user successfully created: {}", response);
		return ResponseEntity.ok(response);
	}
	
	
}
