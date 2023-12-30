package com.jsp.hotel_management_system.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.hotel_management_system.dto.Hotel;
import com.jsp.hotel_management_system.repo.Hotelrepo;

@Repository
public class Hoteldao {
	
	@Autowired
	private Hotelrepo hotelrepo;
	
	public Hotel saveHotel(Hotel hotel) {
		return hotelrepo.save(hotel);
	}
	
	public Hotel updateHotel(Hotel hotel) {
		return hotelrepo.save(hotel);
	}
	
	public Hotel delteHotel(int hid) {
		if(hotelrepo.findById(hid).isPresent()) {
			Hotel hotel=hotelrepo.findById(hid).get();
			hotelrepo.delete(hotel);
			return hotel;
		}else {
			return null;
		}
		
	}
	public Hotel getHotelbyid(int hid) {
		if(hotelrepo.findById(hid).isPresent()) {
			return hotelrepo.findById(hid).get();
		}else {
			return null;
		}
	}

}
