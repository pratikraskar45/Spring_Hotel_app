package com.jsp.HotelManagementSystem.exception;

public class Idnotfoundexception extends RuntimeException{

	private String message="id not found";

	@Override
	public String getMessage() {
		return message;
	}

	public Idnotfoundexception() {
		super();
	}

	public Idnotfoundexception(String message) {
		super();
		this.message = message;
	}
	
	
	
}
