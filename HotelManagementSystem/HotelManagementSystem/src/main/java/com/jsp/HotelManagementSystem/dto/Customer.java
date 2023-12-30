package com.jsp.HotelManagementSystem.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Entity
@Data
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int c_id;
	@NotNull(message = "customer name cannot be null")
	@NotBlank(message = "customer name cannot be blank")
	private String c_name;
	@NotNull(message = "customer address cannot be null")
	@NotBlank(message = "customer address cannot be blank")
	private String c_address;
	@NotNull(message = "customer email cannot be null")
	@NotBlank(message = "customer email cannot be blank")
	@Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}", message = "Invalid Email")
	private String c_email;
	@NotNull(message = "customer password cannot be null")
	@NotBlank(message = "customer password cannot be blank")
	@Pattern(regexp = "^(?=.*[0-9])+(?=.*[a-z])+(?=.*[A-Z])+(?=.*[@#$%^&+=])+(?=\\S+$).{6,}$", message = "min 6 characters mandatory(1 upperCase,1 lowerCase,1 specialCharacter,1 number)")
	private String c_password;
	@Min(value = 6000000000l)
	@Max(value = 9999999999l)
	private long c_phone;
	@NotNull(message = "customer aadhar cannot be null")
	@NotBlank(message = "customer aadhar cannot be blank")
	@Pattern(regexp = "[1-9][1-9]{11}", message = "Invalid Aadhar")//shd give 12 numbers
	private String c_aadhar;
	
}
