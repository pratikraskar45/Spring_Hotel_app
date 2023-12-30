package com.jsp.hotel_management_system.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jsp.hotel_management_system.dto.Booking;

public interface Bookingrepo extends JpaRepository<Booking, Integer> {
	
	@Query("select b from Booking b where b.checkindate=?1")
	public Booking getBookingbycheckindate(String checkindate) ;
	
	@Query("select b from Booking b where b.checkoutdate=?1")
	public Booking getBookingbycheckoutdate(String checkoutdate) ;

}
