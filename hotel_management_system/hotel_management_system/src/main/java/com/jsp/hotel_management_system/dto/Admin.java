package com.jsp.hotel_management_system.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Entity   // This annotation marks the class as a JPA entity, which means it will be persisted to a relational database.
@Data   // This annotation is part of the Lombok library and automatically generates standard boilerplate code for the class, including getters, setters, toString, and equals/hashCode methods.
public class Admin {
	
	@Id   //This annotation is used to declare the field that will act as the primary key in the database.
	@GeneratedValue(strategy = GenerationType.IDENTITY) // This annotation specifies the generation strategy for the values of the primary key. In this case, GenerationType.IDENTITY indicates that the database will automatically assign a unique value to the primary key.
	
	private int admin_id;
	
	
	@NotEmpty(message = "admin name cannot be null or blank")
	private String admin_name;
	
	
	@NotEmpty(message = "admin email cannot be blank or null")
	@Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\\\.[a-z]{2,3}",message = "invalid email")
	private String admin_email;
	
	
	@NotEmpty(message = "password cannot be null or blank")
	@Pattern(regexp = "^(?=.*[0-9])+(?=.*[a-z])+(?=.*[A-Z])+(?=.*[@#$%^&+=])+(?=\\\\S+$).{6,}$",message = "min 6 characters mandatory(1 uppercase,1 lowercase,1 special character,1 number)")
	private String admin_password;
	
    @OneToOne    //This annotation establishes a one-to-one relationship between the Admin entity and another entity, in this case, the Hotel entity.
	private Hotel hotel;
}
