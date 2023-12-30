package com.jsp.HotelManagementSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.HotelManagementSystem.dao.Hoteldao;
import com.jsp.HotelManagementSystem.dto.Hotel;
import com.jsp.HotelManagementSystem.exception.Idnotfoundexception;
import com.jsp.HotelManagementSystem.util.Responsestructure;

@Service
public class Hotelservice {

	@Autowired
	private Hoteldao hoteldao;
	
	public ResponseEntity<Responsestructure<Hotel>> saveHotel(Hotel hotel) {
		Responsestructure<Hotel> responsestructure=new Responsestructure<>();
		responsestructure.setMessage("saved successfully");
		responsestructure.setStatus(HttpStatus.CREATED.value());
		responsestructure.setData(hoteldao.saveHotel(hotel));
		return new ResponseEntity<Responsestructure<Hotel>>(responsestructure,HttpStatus.CREATED);
		
	}
	public ResponseEntity<Responsestructure<Hotel>> updateHotel(int hid,Hotel hotel) {
		Responsestructure<Hotel> responsestructure=new Responsestructure<>();
		Hotel dbHotel=hoteldao.gethotelbyid(hid);
		if(dbHotel!=null) {
			hotel.setHotel_id(hid);
			responsestructure.setMessage("updated succesfully");
			responsestructure.setStatus(HttpStatus.OK.value());
			responsestructure.setData(hoteldao.updateHotel(hotel));
			return new ResponseEntity<Responsestructure<Hotel>>(responsestructure,HttpStatus.OK);
		}else {
			throw new Idnotfoundexception();
		}
		
	}
	public  ResponseEntity<Responsestructure<Hotel>> deleteHotel(int hid) {
		Responsestructure<Hotel> responsestructure=new Responsestructure<>();
		Hotel hotel=hoteldao.gethotelbyid(hid);
		if(hotel!=null) {
			responsestructure.setMessage("deleted succesfully");
			responsestructure.setStatus(HttpStatus.OK.value());
			responsestructure.setData(hoteldao.deleteHotel(hid));
			return new ResponseEntity<Responsestructure<Hotel>>(responsestructure,HttpStatus.OK);
		}else {
			throw new Idnotfoundexception();

		}
	}
	public ResponseEntity<Responsestructure<Hotel>> getHotelbyid(int hid) {
		Responsestructure<Hotel> responsestructure=new Responsestructure<>();
		Hotel hotel=hoteldao.gethotelbyid(hid);
		if(hotel!=null) {
			responsestructure.setMessage("found succesfully");
			responsestructure.setStatus(HttpStatus.FOUND.value());
			responsestructure.setData(hoteldao.gethotelbyid(hid));
			return new ResponseEntity<Responsestructure<Hotel>>(responsestructure,HttpStatus.FOUND);
		}else {
			throw new Idnotfoundexception();
		}
		
	}
}
