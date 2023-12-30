package com.jsp.hotel_management_system.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Entity
@Data
public class Room {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int room_id;
	
	@NotEmpty(message = "room no cannot be null or blank")
	private String room_no;
	
	
	@NotEmpty(message = "room type cannot be null or blank")
	private String room_type;
	
	
	@NotEmpty(message = "room price cannot be null or blank")
	private String room_price;
	
	
	@Min(value = 1,message = "beds cannot be less than 1")
	@Max(value = 10,message = "beds cannot be more than 10")
	private int no_beds;
	
	
	@Min(value = 1)
	@Max(value = 10)
	private int max_people;
	
	
	@NotEmpty(message = "room availability cannot be null or blank")
	@Pattern(regexp = "[Y,N]")
	private String availability;
	
	@Enumerated(EnumType.STRING)
	private Floor floor;
	@ManyToOne
	private Hotel hotel;

}
