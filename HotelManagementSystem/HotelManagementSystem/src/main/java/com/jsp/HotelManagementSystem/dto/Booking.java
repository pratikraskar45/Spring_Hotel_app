package com.jsp.HotelManagementSystem.dto;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import lombok.Data;

@Entity
@Data
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private LocalDateTime check_in_date;
	private LocalDateTime check_out_date;
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
