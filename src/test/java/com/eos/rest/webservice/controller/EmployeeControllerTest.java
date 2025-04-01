package com.eos.rest.webservice.controller;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Collection;
import java.util.Collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import com.eos.rest.webservice.entity.EmployeeDetailsEnitiy;
import com.eos.rest.webservice.service.EmployeeDetailsService;
import com.fasterxml.jackson.databind.ObjectMapper;

public class EmployeeControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Mock
	private EmployeeDetailsService employeeDetailsService;

//	@Mock
//	private BindingResult bindingResult;

//	@Mock
//	private EmployeeDetailsEnitiy employeeDetailsEnitiy;
//	

	@InjectMocks
	private EmployeeController employeeController;

	@Autowired
	private ObjectMapper objectMapper;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void testcreateEmployeeDtails_withValidationError() throws Exception {
		EmployeeDetailsEnitiy invalidDetails = new EmployeeDetailsEnitiy();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		FieldError fieldError = new FieldError("employeeDetailsEnitiy", "name", "Name is required");
		when(bindingResult.getFieldErrors()).thenReturn(Collections.singletonList(fieldError));
		mockMvc.perform(post("/create").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(invalidDetails))).andExpect(status().isBadRequest())
				.andExpect(jsonPath("$.message").value("Validation failed"))
				.andExpect(jsonPath("$.errors.name").value("Name is required"));
	}
}
