package com.jsp.hotel_management_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.hotel_management_system.dto.Booking;
import com.jsp.hotel_management_system.service.Bookingservice;
import com.jsp.hotel_management_system.util.ResponseStructure;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/booking")
public class Bookingcontroller {

	@Autowired
	private Bookingservice bookingservice;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Booking>> savebooking(@Valid @RequestBody Booking booking,@RequestParam int cid,@RequestParam int rid) {
		return bookingservice.savebooking(booking, cid, rid);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<Booking>> updatebooking(@Valid @RequestBody Booking booking,@RequestParam int bid) {
		return bookingservice.updatebooking(booking, bid);
	}
	
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Booking>> deltebooking(@Valid @RequestParam int bid) {
		return bookingservice.deletebooking(bid);
	}
	
	
	@GetMapping
	public ResponseEntity<ResponseStructure<Booking>> getbookingbyid(@Valid @RequestParam int bid) {
		return bookingservice.getbookingbyid(bid);
	}
	
	@GetMapping("/getallbooking")
	public ResponseEntity<ResponseStructure<List<Booking>>> getallbooking() {
		return bookingservice.getallbooking();
	}
	@PutMapping("/closebooking")
	public ResponseEntity<ResponseStructure<Booking>> closebooking(@Valid @RequestParam int bid) {
		return bookingservice.closebooking(bid);
	}	

}
