package com.jsp.hotel_management_system.exception;

public class Idnotfoundexception extends RuntimeException {
	
	private String message = "id not found";

	@Override
	public String getMessage() {
		return message;
	}

	public Idnotfoundexception(String message) {
		this.message = message;
	}

	public Idnotfoundexception() {
		super();
	}
	
	
	
	
}
