package com.jsp.HotelManagementSystem.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.jsp.HotelManagementSystem.dto.Booking;
import com.jsp.HotelManagementSystem.service.Bookingservice;
import com.jsp.HotelManagementSystem.util.Responsestructure;

@RestController
@RequestMapping("/booking")
public class Bookingcontroller {

	@Autowired
	private Bookingservice bookingservice;

	@PostMapping
	public ResponseEntity<Responsestructure<Booking>> saveBooking(@Valid @RequestBody Booking booking, @RequestParam int cid, @RequestParam int rid) {
		return bookingservice.saveBooking(booking, cid, rid);
	}

	@PutMapping
	public ResponseEntity<Responsestructure<Booking>> updateBooking(@Valid @RequestBody Booking booking, @RequestParam int bid) {
		return bookingservice.updateBooking(booking, bid);

	}

	@DeleteMapping
	public ResponseEntity<Responsestructure<Booking>> deleteBooking(@Valid @RequestParam int bid) {
		return bookingservice.deleteBooking(bid);

	}

	@GetMapping("/bookingbyid")
	public ResponseEntity<Responsestructure<Booking>> getBookingbyid(@Valid @RequestParam int bid) {
		return bookingservice.getBookingbyid(bid);

	}

	@GetMapping("/getallbooking")
	public ResponseEntity<Responsestructure<List<Booking>>> getallBookings() {
		return bookingservice.getallbooking();
	}

	@PutMapping("/closebooking")
	public ResponseEntity<Responsestructure<Booking>> closeBooking(@Valid @RequestParam int bid) {
		return bookingservice.closeBooking(bid);

	}
}
