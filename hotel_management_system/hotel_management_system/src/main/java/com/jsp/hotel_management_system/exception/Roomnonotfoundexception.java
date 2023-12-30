package com.jsp.hotel_management_system.exception;



public class Roomnonotfoundexception extends RuntimeException {
	
	private String message = "room no not found";

	@Override
	public String getMessage() {
		
		return message;
	}

	public Roomnonotfoundexception(String message) {
		this.message = message;
	}

	public Roomnonotfoundexception() {
		super();
	}
	
	
	
	
	
	
	

}
