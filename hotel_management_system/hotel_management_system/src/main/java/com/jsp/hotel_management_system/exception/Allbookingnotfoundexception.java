package com.jsp.hotel_management_system.exception;

public class Allbookingnotfoundexception extends RuntimeException {
	
	private String message = "all booking not found";

	@Override
	public String getMessage() {
		
		return message;
	}

	public Allbookingnotfoundexception(String message) {
		
		this.message = message;
	}

	public Allbookingnotfoundexception() {
		super();

	}
	
	
	
	

	

}
