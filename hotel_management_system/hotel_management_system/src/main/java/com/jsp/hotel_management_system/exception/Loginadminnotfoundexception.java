package com.jsp.hotel_management_system.exception;

public class Loginadminnotfoundexception extends RuntimeException {
	
	private String message = "enter valid email and password";

	@Override
	public String getMessage() {
		
		return message;
	}

	public Loginadminnotfoundexception(String message) {
		this.message = message;
	}

	public Loginadminnotfoundexception() {
		super();
	
	}
	

	
	
	
	
	

}
