package com.jsp.hotel_management_system.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Entity
@Data
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int customer_id;
	
	
	@NotEmpty(message = "customer name cannot be null or blank")
	private String customer_name;
	
	
	@NotEmpty(message = "customer address cannot be null or blank")
	private String customer_address;
	
	
	@NotEmpty(message = "customer email cannot be null or blank")
	@Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\\\.[a-z]{2,3}",message = "invalid email")
	private String customer_email;
	
	
	@NotEmpty(message = "customer password cannot be null or blank")
	@Pattern(regexp = "^(?=.*[0-9])+(?=.*[a-z])+(?=.*[A-Z])+(?=.*[@#$%^&+=])+(?=\\\\S+$).{6,}$",message = "min 6 characters mandatory(1 uppercase,1 lowercase,1 special character,1 number)")
	private String customer_password;
	
	
	@Min(value = 6000000000l)
	@Max(value = 9999999999l)
	private long customer_phone;
	
	
	@NotEmpty(message = "adhar cannot be null or blank")
	@Pattern(regexp = "[1-9][1-9]{11}",message = "invalid aadhar")
	private String customer_aadhar;
	
}
