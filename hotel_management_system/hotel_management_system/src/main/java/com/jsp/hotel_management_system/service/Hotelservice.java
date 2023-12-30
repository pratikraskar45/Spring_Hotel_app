package com.jsp.hotel_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.hotel_management_system.dao.Hoteldao;
import com.jsp.hotel_management_system.dto.Hotel;
import com.jsp.hotel_management_system.exception.Idnotfoundexception;
import com.jsp.hotel_management_system.util.ResponseStructure;
@Service
public class Hotelservice {
	
	
	@Autowired
	private Hoteldao hoteldao;
	ResponseStructure<Hotel> responseStructure=new ResponseStructure<>();

	
	public ResponseEntity<ResponseStructure<Hotel>> savehotel(Hotel hotel) {
		responseStructure.setMessage("saved succesfully");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setData(hoteldao.saveHotel(hotel));
		return new ResponseEntity<ResponseStructure<Hotel>>(responseStructure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Hotel>> updatehotel(int hid,Hotel hotel) {
		Hotel dbHotel=hoteldao.getHotelbyid(hid);
		if(dbHotel!=null) {
			hotel.setHid(hid);
			responseStructure.setMessage("hotel updated succesfully");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(hoteldao.updateHotel(hotel));
			return new ResponseEntity<ResponseStructure<Hotel>>(responseStructure,HttpStatus.OK);
		}else {
			throw new Idnotfoundexception();
		}
	}
	
	public ResponseEntity<ResponseStructure<Hotel>> deletehotel(int hid) {
		Hotel hotel=hoteldao.getHotelbyid(hid);
		if(hotel!=null) {
			responseStructure.setMessage("deleted succesfully");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(hoteldao.delteHotel(hid)); 
			return new ResponseEntity<ResponseStructure<Hotel>>(responseStructure,HttpStatus.OK);
		}else {
			throw new Idnotfoundexception();		}
	}
	
	public ResponseEntity<ResponseStructure<Hotel>> gethotelbyid(int hid) {
		Hotel hotel=hoteldao.getHotelbyid(hid);
		if(hotel!=null) {
			responseStructure.setMessage("found succesfully");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(hoteldao.getHotelbyid(hid));
			return new ResponseEntity<ResponseStructure<Hotel>>(responseStructure,HttpStatus.FOUND);
		}else {
			throw new Idnotfoundexception();		}
	}
	
	
	
}
