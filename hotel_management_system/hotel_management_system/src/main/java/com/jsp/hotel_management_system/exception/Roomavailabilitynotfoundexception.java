package com.jsp.hotel_management_system.exception;

public class Roomavailabilitynotfoundexception extends RuntimeException {
	
	private String message = "room availability not found";

	@Override
	public String getMessage() {
		
		return message;
	}

	public Roomavailabilitynotfoundexception(String message) {
		
		this.message = message;
	}

	public Roomavailabilitynotfoundexception() {
		super();
		
	}
	
	
	
	
	
	

}
