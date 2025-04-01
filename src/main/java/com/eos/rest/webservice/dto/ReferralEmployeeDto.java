package com.eos.rest.webservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReferralEmployeeDto {

	private Long id;	
    private String referEmpId;
	private String referEmpName;
    private String referUserName;
    private String referUserEmail;
}
