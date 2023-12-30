package com.jsp.hotel_management_system.exception;

public class Alladminnotfoundexception extends RuntimeException {
	
	private String message = "all admin not found";

	@Override
	public String getMessage() {
		
		return message;
	}

	public Alladminnotfoundexception(String message) {
		
		this.message = message;
	}

	public Alladminnotfoundexception() {
		super();
		
	}
	
	
	
	
	
	
	

}
