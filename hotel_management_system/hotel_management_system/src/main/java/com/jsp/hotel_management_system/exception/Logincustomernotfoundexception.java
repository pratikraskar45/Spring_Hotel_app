package com.jsp.hotel_management_system.exception;

public class Logincustomernotfoundexception extends RuntimeException {
	private String message = "enter valid email and password";

	@Override
	public String getMessage() {
				return message;
	}

	public Logincustomernotfoundexception(String message) {
		
		this.message = message;
	}

	public Logincustomernotfoundexception() {
		super();
		
	}
	
	
	
	

}
