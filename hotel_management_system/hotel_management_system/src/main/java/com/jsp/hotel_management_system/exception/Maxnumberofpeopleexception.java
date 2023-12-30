package com.jsp.hotel_management_system.exception;

public class Maxnumberofpeopleexception extends RuntimeException {

	private String message="we cannot have these number of people in the selected room";
	
	@Override
	public String getMessage() {
		return message;
		
	}

	public Maxnumberofpeopleexception(String message) {
		this.message = message;
	}

	public Maxnumberofpeopleexception() {
		super();
	}
	
	
}
