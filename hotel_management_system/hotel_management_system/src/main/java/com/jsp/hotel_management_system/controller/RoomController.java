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

import com.jsp.hotel_management_system.dto.Room;
import com.jsp.hotel_management_system.service.Roomservice;
import com.jsp.hotel_management_system.util.ResponseStructure;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/room")
public class RoomController {

	@Autowired
	private Roomservice roomservice;

	@PostMapping
	public ResponseEntity<ResponseStructure<Room>> saveroom(@Valid @RequestBody Room room, @RequestParam int hid) {
		return roomservice.saveroom(room, hid);
	}

	@PutMapping
	public ResponseEntity<ResponseStructure<Room>> updateroom(@Valid @RequestParam int rid, @RequestBody Room room) {
		return roomservice.updateroom(rid, room);
	}

	@DeleteMapping
	public ResponseEntity<ResponseStructure<Room>> deleteroom(@Valid @RequestParam int rid) {
		return roomservice.deleteroom(rid);
	}

	@GetMapping
	public ResponseEntity<ResponseStructure<Room>> getroombyid(@Valid @RequestParam int rid) {
		return roomservice.getroombyid(rid);
	}

	@GetMapping("/roombyno")
	public ResponseEntity<ResponseStructure<Room>> getroombyno(@Valid @RequestParam String room_no) {
		return roomservice.getroombyno(room_no);
	}

	@GetMapping("/roombytype")
	public ResponseEntity<ResponseStructure<List<Room>>> getroombytype(@Valid @RequestParam String room_type) {
		return roomservice.getroombytype(room_type);
	}

	@GetMapping("/availability")
	public ResponseEntity<ResponseStructure<List<Room>>> getroombyavaliability(@Valid @RequestParam String availability) {
		return roomservice.getroombyavailability(availability);
	}

	@GetMapping("/getallroom")
	public ResponseEntity<ResponseStructure<List<Room>>> getallrooms() {
		return roomservice.getallrooms();
	}

}
