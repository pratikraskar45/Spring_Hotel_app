package com.jsp.hotel_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.hotel_management_system.dao.Hoteldao;
import com.jsp.hotel_management_system.dao.Roomdao;
import com.jsp.hotel_management_system.dto.Hotel;
import com.jsp.hotel_management_system.dto.Room;
import com.jsp.hotel_management_system.exception.Idnotfoundexception;
import com.jsp.hotel_management_system.exception.Roomavailabilitynotfoundexception;
import com.jsp.hotel_management_system.exception.Roombytypenotfoundexception;
import com.jsp.hotel_management_system.exception.Roomnonotfoundexception;
import com.jsp.hotel_management_system.util.ResponseStructure;
@Service
public class Roomservice {
	
	
	@Autowired
	private Roomdao roomdao;
	
	@Autowired
	private Hoteldao hoteldao;
	
	ResponseStructure<Room> responseStructure=new ResponseStructure<>();
	
	
	public ResponseEntity<ResponseStructure<Room>> saveroom(Room room,int hid) {
		Hotel hotel=hoteldao.getHotelbyid(hid);
		room.setHotel(hotel);
		Room dbRoom=roomdao.saveRoom(room);
		if(dbRoom!=null) {
			responseStructure.setMessage("room saved succesfully");
			responseStructure.setStatus(HttpStatus.CREATED.value());
			responseStructure.setData(dbRoom);
			return new ResponseEntity<ResponseStructure<Room>>(responseStructure,HttpStatus.CREATED);
		}else {
			throw new Idnotfoundexception();
		}
		
	}
	
	public ResponseEntity<ResponseStructure<Room>> updateroom(int rid,Room room) {
		Room dbroom=roomdao.getRoombyid(rid);
		if(dbroom!=null) {
			room.setRoom_id(rid);
			room.setHotel(dbroom.getHotel());
			responseStructure.setMessage("room updated succefully");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(roomdao.updateRoom(room));
			return new ResponseEntity<ResponseStructure<Room>>(responseStructure,HttpStatus.OK);
		}else {
			throw new Idnotfoundexception();
		}
	}
	
	public ResponseEntity<ResponseStructure<Room>> deleteroom(int rid) {
		Room room=roomdao.getRoombyid(rid);
		if(room!=null) {
			responseStructure.setMessage("room deleted succesfully");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(roomdao.deleteRoom(rid));
			return new ResponseEntity<ResponseStructure<Room>>(responseStructure,HttpStatus.OK);

		}else {
			throw new Idnotfoundexception();
		}
	}
	
	public ResponseEntity<ResponseStructure<Room>> getroombyid(int rid) {
		Room room=roomdao.getRoombyid(rid);
		if(room!=null) {
			responseStructure.setMessage("room found succesfully");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(room);
			return new ResponseEntity<ResponseStructure<Room>>(responseStructure,HttpStatus.FOUND);

		}else {
			throw new Idnotfoundexception();
		}
	}
	
	
	public ResponseEntity<ResponseStructure<List<Room>>> getroombytype(String room_type) {
		List<Room> room=roomdao.getroombytype(room_type);
		if(room!=null) {
			ResponseStructure<List<Room>> responseStructure=new ResponseStructure<>();
			responseStructure.setMessage("room found succesfully");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(room);
			return new ResponseEntity<ResponseStructure<List<Room>>>(responseStructure,HttpStatus.FOUND);
		}else {
			throw new Roombytypenotfoundexception();
		}
	}
	
	public ResponseEntity<ResponseStructure<Room>> getroombyno(String room_no) {
		Room room=roomdao.getRoombyno(room_no);
		if(room!=null) {
			responseStructure.setMessage("room found succesfully");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(room);
			return new ResponseEntity<ResponseStructure<Room>>(responseStructure,HttpStatus.FOUND);
		}else {
			throw new Roomnonotfoundexception();
		}
	}
	
	public ResponseEntity<ResponseStructure<List<Room>>> getroombyavailability(String availability) {
		ResponseStructure<List<Room>> responseStructure=new ResponseStructure<>();
		List<Room> rooms=roomdao.getRoomsnyavaliability(availability);
		if(rooms!=null) {
			responseStructure.setMessage("room found succesfully");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(rooms);
			return new ResponseEntity<ResponseStructure<List<Room>>>(responseStructure,HttpStatus.FOUND);

		}else {
			throw new Roomavailabilitynotfoundexception();
		}

	}
	
	public ResponseEntity<ResponseStructure<List<Room>>> getallrooms() {
		ResponseStructure<List<Room>> responseStructure=new ResponseStructure<>();
		responseStructure.setMessage("rooms found succesfully");
		responseStructure.setStatus(HttpStatus.FOUND.value());
		responseStructure.setData(roomdao.getallRooms());
		return new ResponseEntity<ResponseStructure<List<Room>>>(responseStructure,HttpStatus.FOUND);
		 

	}

}
