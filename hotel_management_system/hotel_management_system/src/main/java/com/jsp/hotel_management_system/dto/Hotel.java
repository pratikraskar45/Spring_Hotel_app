package com.jsp.hotel_management_system.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Entity
@Data
public class Hotel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int hid;
	
	@NotNull(message = "hotel name cannot be null")
	@NotBlank(message = "hotel name cannot be blank")
	private String hname;
	
	
	@NotEmpty(message = "hotel gst cannot be null or blank")
	private String hgst;
	
	
	@NotEmpty(message = "hotel address cannot be null or blank")
	private String haddress;
	
	@NotEmpty(message = "hotel manager cannot be null or blank")
	private String hmanager;
	
	
	@NotEmpty(message = "hotel owner cannot be null or blank")
	private String howner;
	
	private int hrating;
	

}
