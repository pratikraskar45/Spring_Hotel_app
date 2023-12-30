package com.jsp.hotel_management_system.dto;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;

@Entity
@Data
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int booking_id;
	
	private LocalDateTime checkindate;
	
	private LocalDateTime checkoutdate;
	
	@Min(value = 1,message = "cannot be less than 1")
	@Max(value = 10,message = "cannot be more than 10")
	private int no_people;
	
	
	@Min(value = 1)
	@Max(value = 5)
	private int rating;
	
	@ManyToOne
	private Customer customer;
	
	@OneToOne
	private Room room;

}
