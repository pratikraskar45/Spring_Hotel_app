package com.jsp.HotelManagementSystem.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class Hotel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int hotel_id;
	@NotNull(message = "hotel name cannot be null")
	@NotBlank(message = "hotel name cannot be blank")
	private String hotel_name;
	@NotNull(message = "hotel gst cannot be null")
	@NotBlank(message = "hotel gst cannot be blank")
	private String hotel_gst;
	@NotNull(message = "hotel address cannot be null")
	@NotBlank(message = "hotel address cannot be blank")
	private String hotel_address;
	@NotNull(message = "hotel manager cannot be null")
	@NotBlank(message = "hotel manager cannot be blank")
	private String hotel_manager;
	@NotNull(message = "hotel owner cannot be null")
	@NotBlank(message = "hotel owner cannot be blank")
	private String hotel_owner;
	private int hotel_rating;
	
	
}
