package com.jsp.hotel_management_system.exception;

public class Roombytypenotfoundexception extends RuntimeException {
	
	private String message = "room by type not found";

	@Override
	public String getMessage() {
		
		return message;
	}

	public Roombytypenotfoundexception(String message) {

		this.message = message;
	}

	public Roombytypenotfoundexception() {
		super();
	
	}
	
	
	
	
	

}
