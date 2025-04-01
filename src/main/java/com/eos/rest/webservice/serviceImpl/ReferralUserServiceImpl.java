package com.eos.rest.webservice.serviceImpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eos.rest.webservice.dto.ReferralEmployeeDto;
import com.eos.rest.webservice.entity.ReferralEnitity;
import com.eos.rest.webservice.exception.EmailExistsException;
import com.eos.rest.webservice.exception.MobileNoExistsException;
import com.eos.rest.webservice.repository.ReferralEmployeeRepository;
import com.eos.rest.webservice.service.ReferralEmployeeService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ReferralUserServiceImpl implements ReferralEmployeeService{
	
	@Autowired
	private ModelMapper modelMapper;
	
	private ReferralEmployeeRepository referralEmployeeRepository;
	 
	public ReferralUserServiceImpl(ReferralEmployeeRepository referralEmployeeRepository) {
		super();
		this.referralEmployeeRepository = referralEmployeeRepository;
	}

	@Override
	public ReferralEmployeeDto createReferralEmployee(ReferralEnitity entity) {
		if(!entity.getReferUserEmail().isBlank()) {
			String email = entity.getReferUserEmail();
			checkReferUserEmailIsUnique(email);
		}
		if(!entity.getUserMobNo().isBlank()) {
			String mobileNo = entity.getUserMobNo();
			checkReferUserMobileNoIsUnique(mobileNo);
		}
	    ReferralEnitity savedEntity = 	referralEmployeeRepository.save(entity);
	    ReferralEmployeeDto result = modelMapper.map(savedEntity, ReferralEmployeeDto.class);
		return result;
	}

	private void checkReferUserMobileNoIsUnique(String mobileNo) {

		try {
			boolean uniqueMobileNoCheck = referralEmployeeRepository.existsByUserMobNo(mobileNo);
			if(uniqueMobileNoCheck) {
				throw new MobileNoExistsException("this mobile no person is already reffered " +mobileNo);
			}else {
				log.info("Mobile No {} is unique, proceed with referral.", mobileNo);
			}
		} catch (Exception e) {
			log.error("Error occurred while checking Mobile No uniqueness: {}", e.getMessage());
			throw new RuntimeException("Error occurred while checking Mobile No uniqueness.", e);
		}
	}

	private void checkReferUserEmailIsUnique(String email) {
    
		try {
			boolean uniqueCheck = referralEmployeeRepository.existsByReferUserEmail(email);
			if(uniqueCheck) {
				throw new EmailExistsException("Email is already used for referral: " + email);
			}else {
				log.info("Email {} is unique, proceed with referral.", email);
			}
		} catch (Exception e) {
			log.error("Error occurred while checking email uniqueness: {}", e.getMessage());
			 throw new RuntimeException("Error occurred while checking email uniqueness.", e);
		}
		
	}

}
