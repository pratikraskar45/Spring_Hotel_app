package com.jsp.hotel_management_system.controller;

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

import com.jsp.hotel_management_system.dto.Hotel;
import com.jsp.hotel_management_system.service.Hotelservice;
import com.jsp.hotel_management_system.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/hotel")
public class Hotelcontroller {

	@Autowired
	private Hotelservice hotelservice;

	@ApiOperation(value = "save hotel",notes = "api is used to save hotel")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "hotel saved succesfully"),
			@ApiResponse(code = 404,message ="hotel not saved give proper input")})
	@PostMapping
	public ResponseEntity<ResponseStructure<Hotel>> savehotel(@Valid @RequestBody Hotel hotel) {
		return hotelservice.savehotel(hotel);
	}

	@ApiOperation(value = "update hotel",notes = "api is used to update hotel")
	@ApiResponses(value = {@ApiResponse(code = 200,message = "hotel updated succesfully"),
			@ApiResponse(code = 404,message ="hotel not updated give proper input")})
	@PutMapping
	public ResponseEntity<ResponseStructure<Hotel>> updatehotel(@Valid @RequestParam int hid, @RequestBody Hotel hotel) {
		return hotelservice.updatehotel(hid, hotel);
	}

	@ApiOperation(value = "delete hotel",notes = "api is used to delete hotel")
	@ApiResponses(value = {@ApiResponse(code = 200,message = "hotel deleted succesfully"),
			@ApiResponse(code = 404,message ="hotel not deleted give proper input")})
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Hotel>> deletehotel(@Valid @RequestParam int hid) {
		return hotelservice.deletehotel(hid);
	}

	@ApiOperation(value = "get hotel by id",notes = "api is used to get hotel details based on id")
	@ApiResponses(value = {@ApiResponse(code = 302,message = "hotel found succesfully"),
			@ApiResponse(code = 404,message ="hotel not found give proper input")})
	@GetMapping
	public ResponseEntity<ResponseStructure<Hotel>> gethotelbyid(@Valid @RequestParam int hid) {
		return hotelservice.gethotelbyid(hid);
	}
}
