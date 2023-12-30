package com.jsp.HotelManagementSystem.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.HotelManagementSystem.dto.Hotel;
import com.jsp.HotelManagementSystem.service.Hotelservice;
import com.jsp.HotelManagementSystem.util.Responsestructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/hotel")
public class Hotelcontroller {

	@Autowired
	private Hotelservice hotelservice;

	@ApiOperation(value = "save hotel",notes = "api is used to save hotel")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "hotel succesfully created"),
			@ApiResponse(code = 404,message = "hotel not saved give proper input")})
	@PostMapping
	public ResponseEntity<Responsestructure<Hotel>> saveHotel(@Valid @RequestBody Hotel hotel) {
		return hotelservice.saveHotel(hotel);

	}

	@ApiOperation(value = "update hotel",notes = "api is used to update hotel")
	@ApiResponses(value = {@ApiResponse(code = 200,message = "hotel succesfully updated"),
			@ApiResponse(code = 404,message = "hotel not updated give proper input")})
	@PutMapping
	public ResponseEntity<Responsestructure<Hotel>> updateHotel(@Valid @RequestParam int hid, @RequestBody Hotel hotel) {
		return hotelservice.updateHotel(hid, hotel);

	}

	@ApiOperation(value = "delete hotel",notes = "api is used to delete hotel")
	@ApiResponses(value = {@ApiResponse(code = 200,message = "hotel succesfully deleted"),
			@ApiResponse(code = 404,message = "hotel not deleted give proper input")})
	@DeleteMapping
	public ResponseEntity<Responsestructure<Hotel>> deleteHotel(@Valid @RequestParam int hid) {
		return hotelservice.deleteHotel(hid);

	}

	@ApiOperation(value = "get hotel by id",notes = "api is used to get hotel details based on id")
	@ApiResponses(value = {@ApiResponse(code = 302,message = "succesfully found hotel"),
			@ApiResponse(code = 404,message = "hotel not found give proper input")})
	@GetMapping
	public ResponseEntity<Responsestructure<Hotel>> gethotelbyid(@Valid @RequestParam int hid) {
		return hotelservice.getHotelbyid(hid);

	}
}
