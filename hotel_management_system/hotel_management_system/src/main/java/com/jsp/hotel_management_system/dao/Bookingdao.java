package com.jsp.hotel_management_system.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.hotel_management_system.dto.Booking;
import com.jsp.hotel_management_system.repo.Bookingrepo;

@Repository
public class Bookingdao {
	@Autowired
	private Bookingrepo bookingrepo;
	
	public Booking saveBooking(Booking booking) {
		return bookingrepo.save(booking);
	}
	
	public Booking updateBooking(Booking booking) {
		return bookingrepo.save(booking);
	}
	
	public Booking deleteBooking(Booking booking) {
		bookingrepo.delete(booking);
		return booking;
	}
	
	public Booking getBookingbyid(int bid) {
		if(bookingrepo.findById(bid).isPresent()) {
			return bookingrepo.findById(bid).get();
			
		}else {
			return null;
		}
	}
	public List<Booking> getallBookings() {
		return bookingrepo.findAll(); 
	}
	
	public Booking getBookingbycheckin(String checkindate) {
		if (bookingrepo.getBookingbycheckindate(checkindate)!=null) {
			return bookingrepo.getBookingbycheckindate(checkindate);
			
		}else {
			return null;
		}
		
	}
	public Booking getbookingbycheckoutdate(String checkoutdate) {
		if (bookingrepo.getBookingbycheckoutdate(checkoutdate)!=null) {
			return bookingrepo.getBookingbycheckoutdate(checkoutdate);
		}else {
			return null;
		}
		
	}
	

}
