package com.eos.rest.webservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "empDetails")
public class EmployeeDetailsEnitiy {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "employeeId")
	@NotBlank(message = "Emp Id should not blank entity")
	@Size(min = 5, max = 5, message = "Emp Id should be exactly 6 digits")
	private String employeeId;

	@Column(name = "loginId")
	private String loginId;
	
	@Column(name = "employmentType")
	private String employmentType;
	
	@Column(name = "ftePte")
	private String ftePte;
	
	@Column(name = "countFtePte")
	private int countFtePte;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "designation")
	private String designation;
	
	@Column(name = "lob")
	private String lob;
	
	@Column(name = "inboundOutbound")
	private String inboundOutbound;
	
	@Column(name = "department")
	private String department;
	
	@Column(name = "costCenterCode")
	private String costCenterCode;
	
	@Column(name = "process")
	private String process;
	
	@Column(name = "subProcess")
	private String subProcess;
	
	@Column(name = "reportingTo")
	private String reportingTo;
	
	@Column(name = "amDm")
	private String amDm;
	
	@Column(name = "manager")
	private String manager;
	
	@Column(name = "processHead")
	private String processHead;
	
	@Column(name = "businessHead")
	private String businessHead;
	
	@Column(name = "officeLocation")
	private String officeLocation;
	
	@Column(name = "addressLocation")
	private String addressLocation;
	
	@Column(name = "dateOnFloor")
	private String dateOnFloor;
	
	@Column(name = "dateOnFloorCurrentProcess")
	private String dateOnFloorCurrentProcess;
	
	@Column(name = "aon")
	private String aon;
	
	@Column(name = "bucket")
	private String bucket;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "voluntaryInvoluntary")
	private String voluntaryInvoluntary;
	
	@Column(name = "attritionStatus")
	private String attritionStatus;
	
	@Column(name = "attritionReason")
	private String attritionReason;
	
	@Column(name = "dateOfAttrition")
	private String dateOfAttrition;
	
	@Column(name = "lastWorkingDate")
	private String lastWorkingDate;
	
	@Column(name = "dateOfTransfer")
	private String dateOfTransfer;
	
	@Column(name = "remarks1")
	private String remarks1;
	
	@Column(name = "remarks2")
	private String remarks2;
	
	@Column(name = "lastUpdatedOn")
	private String lastUpdatedOn;
	
	@Column(name = "lastUpdateReceivedFrom")
	private String lastUpdateReceivedFrom;
	
	@Column(name = "lastUpdatedBy")
	private String lastUpdatedBy;
	
	@Column(name = "sheets")
	private String sheets;
	
	@Column(name = "shortingData")
	private String shortingData;
	
	
//	@Column(name = "email")
//	@Email(message = "Invalid email format entity")
//	@NotBlank(message = "Email should not be blank")
//	private String email;

}
