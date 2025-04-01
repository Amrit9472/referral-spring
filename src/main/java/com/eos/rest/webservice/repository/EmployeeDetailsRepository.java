package com.eos.rest.webservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.eos.rest.webservice.entity.EmployeeDetailsEnitiy;

public interface EmployeeDetailsRepository extends JpaRepository<EmployeeDetailsEnitiy, Long> {

	Optional<EmployeeDetailsEnitiy> findByEmployeeId(@Param("empId") String empId);

}
