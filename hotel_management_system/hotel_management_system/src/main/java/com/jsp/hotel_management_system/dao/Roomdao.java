package com.jsp.hotel_management_system.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.hotel_management_system.dto.Room;
import com.jsp.hotel_management_system.repo.Roomrepo;

@Repository
public class Roomdao {
	@Autowired
	private Roomrepo roomrepo;
	
	public Room saveRoom(Room room) {
		return roomrepo.save(room);
	}

	public Room updateRoom(Room room) {
		return roomrepo.save(room);
	}

	public Room deleteRoom(int rid) {
		if (roomrepo.findById(rid).isPresent()) {
			Room room = roomrepo.findById(rid).get();
			roomrepo.delete(room);
			return room;
		} else {
			return null;
		}
	}

	public Room getRoombyid(int rid) {
		if (roomrepo.findById(rid).isPresent()) {
			return roomrepo.findById(rid).get();
		} else {
			return null;
		}
	}

	public List<Room> getallRooms() {
		return roomrepo.findAll();
	}
	
	public Room getRoombyno(String room_no) {
		if (roomrepo.getRoombyno(room_no)!=null) {
			return roomrepo.getRoombyno(room_no);
		}else {
			return null;
		}	
	}
	public List<Room>  getroombytype(String room_type) {
		if (roomrepo.getRoomsbytype(room_type)!=null) {
			return roomrepo.getRoomsbytype(room_type);
		} else {
			return null;
		}
		
	}
	public List<Room> getRoomsnyavaliability(String availability) {
		if (roomrepo.getRoomsbyavaliability(availability)!=null) {
			return roomrepo.getRoomsbyavaliability(availability);
		} else {
			return null;
		}		
	}

}
