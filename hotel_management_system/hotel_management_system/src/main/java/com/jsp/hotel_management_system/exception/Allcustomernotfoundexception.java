package com.jsp.hotel_management_system.exception;

public class Allcustomernotfoundexception extends RuntimeException {
	
	private String message = "all customer not found";

	@Override
	public String getMessage() {
		
		return message;
	}

	public Allcustomernotfoundexception(String message) {
		
		this.message = message;
	}

	public Allcustomernotfoundexception() {
		super();
	
	}
	
	
	
	

}
