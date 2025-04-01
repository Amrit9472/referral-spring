package com.eos.rest.webservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "referralEnitity")
public class ReferralEnitity {
     
	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "refEmpId")
	@NotBlank(message = "Refer Emp ID cannot be null")
	private String referEmpId;
	
    @Column(name = "refEmpName")
    @NotBlank(message = "Refer Emp Name cannot be null")
    @Size(min = 2, max = 100, message = "Refer Emp Name must be between 2 and 100 characters")
	private String referEmpName;
    
    @Column(name = "refUserName")
    @NotBlank(message = "Refered User Name should Not blank")
    @Size(min = 2, max = 100, message = "Referral User Name must be between 2 and 100 characters")
	private String referUserName;
    
    @Column(name = "refUserEmail")
    @Email(message = "Invalid email format")
	private String referUserEmail;
    
    @Column(name = "userMobNo")
    @Size(min = 10, max = 10 ,message = "Enter mobile No without country code")
    @NotBlank(message = "mobile No should No be blank")
    private String userMobNo;
    
}
