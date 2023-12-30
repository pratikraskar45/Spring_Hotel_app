package com.jsp.hotel_management_system.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jsp.hotel_management_system.dto.Room;

public interface Roomrepo extends JpaRepository<Room, Integer> {
	
	@Query("select r from Room r where r.room_no=?1")
	public Room getRoombyno(String room_no) ;
	
	
	@Query("select r from Room r where r.room_type=?1")
	public List<Room> getRoomsbytype(String room_type) ;
	
	@Query("select r from Room r where r.availability=?1")
	public List<Room> getRoomsbyavaliability(String availability) ;

}
