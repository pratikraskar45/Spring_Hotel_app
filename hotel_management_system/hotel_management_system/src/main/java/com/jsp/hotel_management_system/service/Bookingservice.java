package com.jsp.hotel_management_system.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.hotel_management_system.dao.Bookingdao;
import com.jsp.hotel_management_system.dao.Customerdao;
import com.jsp.hotel_management_system.dao.Roomdao;
import com.jsp.hotel_management_system.dto.Booking;
import com.jsp.hotel_management_system.dto.Customer;
import com.jsp.hotel_management_system.dto.Room;
import com.jsp.hotel_management_system.exception.Allbookingnotfoundexception;
import com.jsp.hotel_management_system.exception.Idnotfoundexception;
import com.jsp.hotel_management_system.exception.Maxnumberofpeopleexception;
import com.jsp.hotel_management_system.util.ResponseStructure;

@Service
public class Bookingservice {

	@Autowired
	private Bookingdao bookingdao;
	@Autowired
	private Customerdao customerdao;
	@Autowired
	private Roomdao roomdao;
	
	ResponseStructure<Booking> responseStructure=new ResponseStructure<>();
	
	public ResponseEntity<ResponseStructure<Booking>> savebooking(Booking booking,int cid,int rid) {
		Room room=roomdao.getRoombyid(rid);
		room.setAvailability("N");
		if(booking.getNo_people()<=room.getMax_people()) {
			Room room2=roomdao.updateRoom(room);
			Customer customer=customerdao.getCustomerbyid(cid);
			booking.setCustomer(customer);
			booking.setRoom(room2);
			LocalDateTime checkinDateTime=LocalDateTime.now();
			booking.setCheckindate(checkinDateTime);
			responseStructure.setMessage("booking saved succesfully");
			responseStructure.setStatus(HttpStatus.CREATED.value());
			responseStructure.setData(bookingdao.saveBooking(booking));
			return new ResponseEntity<ResponseStructure<Booking>>(responseStructure,HttpStatus.CREATED);
		}else {
			return null;
		}
	}
	
	public ResponseEntity<ResponseStructure<Booking>> updatebooking(Booking booking, int bid) {
		Booking dbbooking = bookingdao.getBookingbyid(bid);
		if (dbbooking != null) {
			if (booking.getNo_people() <= dbbooking.getRoom().getMax_people()) {
				booking.setBooking_id(bid);
				booking.setCustomer(dbbooking.getCustomer());
				booking.setRoom(dbbooking.getRoom());
				booking.setCheckindate(dbbooking.getCheckindate());
				booking.setCheckoutdate(dbbooking.getCheckoutdate());
				responseStructure.setMessage("booking updated succesfully");
				responseStructure.setStatus(HttpStatus.OK.value());
				responseStructure.setData(bookingdao.updateBooking(booking));
				return new ResponseEntity<ResponseStructure<Booking>>(responseStructure, HttpStatus.OK);
			} else {
				throw new Maxnumberofpeopleexception();
			}
		}
		throw new Idnotfoundexception();
	}

	public ResponseEntity<ResponseStructure<Booking>> deletebooking(int bid) {
		Booking booking = bookingdao.getBookingbyid(bid);
		if (booking != null) {
			responseStructure.setMessage("deleted succesfully");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(bookingdao.deleteBooking(booking));
			return new ResponseEntity<ResponseStructure<Booking>>(responseStructure, HttpStatus.OK);

		} else {
			throw new Idnotfoundexception();
		}
	}

	public ResponseEntity<ResponseStructure<Booking>> getbookingbyid(int bid) {
		Booking booking = bookingdao.getBookingbyid(bid);
		if (booking != null) {
			responseStructure.setMessage("booking found succesfully");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(bookingdao.getBookingbyid(bid));
			return new ResponseEntity<ResponseStructure<Booking>>(responseStructure, HttpStatus.FOUND);

		} else {
			throw new Idnotfoundexception();
		}
	}

	public ResponseEntity<ResponseStructure<List<Booking>>> getallbooking() {
		ResponseStructure<List<Booking>> responseStructure = new ResponseStructure<>();
		if (bookingdao.getallBookings() != null) {
			responseStructure.setMessage("booking found succesfully");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(bookingdao.getallBookings());
			return new ResponseEntity<ResponseStructure<List<Booking>>>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new Allbookingnotfoundexception();
		}
	}

	public ResponseEntity<ResponseStructure<Booking>> closebooking(int bid) {
		Booking booking = bookingdao.getBookingbyid(bid);
		if (booking != null) {
			LocalDateTime dateTime = LocalDateTime.now();
			booking.setCheckoutdate(dateTime);
			Room room = booking.getRoom();
			room.setAvailability("Y");
			booking.setRoom(room);
			responseStructure.setMessage("succesfully closed the booking");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(bookingdao.updateBooking(booking));
			return new ResponseEntity<ResponseStructure<Booking>>(responseStructure, HttpStatus.OK);

		} else {
			throw new Idnotfoundexception();
		}
	}

}
	


