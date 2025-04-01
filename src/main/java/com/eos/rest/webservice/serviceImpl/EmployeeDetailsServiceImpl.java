package com.eos.rest.webservice.serviceImpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eos.rest.webservice.dto.EmployeeDetailsDto;
import com.eos.rest.webservice.entity.EmployeeDetailsEnitiy;
import com.eos.rest.webservice.exception.EmployeeDetailsNotFoundException;
import com.eos.rest.webservice.repository.EmployeeDetailsRepository;
import com.eos.rest.webservice.service.EmployeeDetailsService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class EmployeeDetailsServiceImpl implements EmployeeDetailsService{

	@Autowired
	private ModelMapper modelMapper;
	
	private EmployeeDetailsRepository employeeDetailsRepository;
	
	
	public EmployeeDetailsServiceImpl(EmployeeDetailsRepository employeeDetailsRepository) {
		super();
		this.employeeDetailsRepository = employeeDetailsRepository;
	}


	@Override
	public EmployeeDetailsDto createEmployee(EmployeeDetailsEnitiy entity) {
		log.info("Creating employee with details EmployeeDetailsServiceImpl: {}", entity);
		EmployeeDetailsEnitiy saveEmployee = employeeDetailsRepository.save(entity);
		log.info("Employee successfully created with ID EmployeeDetailsServiceImpl: {}", saveEmployee.getEmployeeId());
		EmployeeDetailsDto result = modelMapper.map(saveEmployee, EmployeeDetailsDto.class);
		log.info("Created EmployeeDetailsDto EmployeeDetailsServiceImpl : {}", result);
		return result;
	}


	@Override
	public EmployeeDetailsDto searchEmployeeDetails(String empId) {
	    log.info("Searching for employee with ID EmployeeDetailsServiceImpl: {}", empId);
	    EmployeeDetailsEnitiy searchEmployee =null;
	    try {
		    searchEmployee = employeeDetailsRepository.findByEmployeeId(empId).orElseThrow(
					()-> new EmployeeDetailsNotFoundException("Your Emp id is not valid = " + empId));
	        log.info("Employee details found for ID: {}: {}", empId, searchEmployee);
		} catch (Exception e) {
	        log.error("No customer found with ID: {}", empId);
	        throw e;
		}
		EmployeeDetailsDto result = modelMapper.map(searchEmployee, EmployeeDetailsDto.class);
		 log.info("Mapped EmployeeDetailsDto for ID: {}", empId);
		return result;
	}
}
