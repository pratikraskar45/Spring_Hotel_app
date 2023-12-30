package com.jsp.hotel_management_system.exception;

public class Emailnotfoundexception extends RuntimeException {
	
	private String message = "email not found";
	
	
  //alt_shift+s then override,impliments getmessage()
	@Override
	public String getMessage() {
		return message;
	}
	
	//alt_shift+s then  constructor using filds
  public Emailnotfoundexception(String message) {
	super();
	this.message = message;
}
  ////alt_shift+s then constructor from super class and select runtimeexception
public Emailnotfoundexception() {
	super();
	
}
}
