package com.eos.rest.webservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eos.rest.webservice.entity.ReferralEnitity;

public interface ReferralEmployeeRepository extends JpaRepository<ReferralEnitity, Long>  {

	boolean existsByReferUserEmail(String email);

	boolean existsByUserMobNo(String mobileNo);

}
