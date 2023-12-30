package com.jsp.hotel_management_system.exception;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.jsp.hotel_management_system.util.ResponseStructure;

@ControllerAdvice

public class ApplicationExceptionhandler extends ResponseEntityExceptionHandler {
	ResponseStructure<String> responseStructure=new ResponseStructure<>();
	
	@ExceptionHandler(Idnotfoundexception.class)
	public ResponseEntity<ResponseStructure<String>> idnotfound(Idnotfoundexception ex) {
		responseStructure.setMessage("id not found");
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setData(ex.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<ResponseStructure<String>> nosuchelement(NoSuchElementException ex) {
		responseStructure.setMessage("no element found");
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setData(ex.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);

	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<ResponseStructure<String>> constraintviolationexception(ConstraintViolationException ex) {
		responseStructure.setMessage(ex.getMessage());
		responseStructure.setStatus(HttpStatus.BAD_REQUEST.value());
		responseStructure.setData("this particular field cannot be null or blank");
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.BAD_REQUEST);

	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		List<ObjectError> list=ex.getAllErrors();
		Map<String, String> map=new LinkedHashMap<>();
		for(ObjectError error:list) {
			String fieldname=((FieldError)error).getField();
			String message=((FieldError)error).getDefaultMessage();
			map.put(fieldname, message);
		}
		return new ResponseEntity<Object>(map,HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(Maxnumberofpeopleexception.class)
	public ResponseEntity<ResponseStructure<String>> maxnumberofpeople(Maxnumberofpeopleexception ex) {
		responseStructure.setMessage("max limit of people for particular room");
		responseStructure.setStatus(HttpStatus.BAD_REQUEST.value());
		responseStructure.setData(ex.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(Emailnotfoundexception.class)
	public ResponseEntity<ResponseStructure<String>> emailnotfound(Emailnotfoundexception ex) {
		responseStructure.setMessage("email not found");
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setData(ex.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
		
	}
	
	
	@ExceptionHandler(Loginadminnotfoundexception.class)
	public ResponseEntity<ResponseStructure<String>> loginadminnotfound(Loginadminnotfoundexception ex) {
		responseStructure.setMessage("login admin not found");
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setData(ex.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
		
	}
	
	
	@ExceptionHandler(Alladminnotfoundexception.class)
	public ResponseEntity<ResponseStructure<String>> alladminnotfound(Alladminnotfoundexception ex) {
		responseStructure.setMessage("all admin not found");
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setData(ex.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
		
	}
	
	
	@ExceptionHandler(Allbookingnotfoundexception.class)
	public ResponseEntity<ResponseStructure<String>> allbookingnotfound(Allbookingnotfoundexception ex) {
		responseStructure.setMessage("all booking not found");
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setData(ex.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
		
	}
	
	
	@ExceptionHandler(Logincustomernotfoundexception.class)
	public ResponseEntity<ResponseStructure<String>> logincustomernotfound(Logincustomernotfoundexception ex) {
		responseStructure.setMessage("login customer  not found");
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setData(ex.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(Allcustomernotfoundexception.class)
	public ResponseEntity<ResponseStructure<String>> allcustomernotfound(Allcustomernotfoundexception ex) {
		responseStructure.setMessage("all customer not found");
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setData(ex.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(Roombytypenotfoundexception.class)
	public ResponseEntity<ResponseStructure<String>> roombytypenotfoundexception(Roombytypenotfoundexception ex) {
		responseStructure.setMessage("room by type not found");
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setData(ex.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(Roomnonotfoundexception.class)
	public ResponseEntity<ResponseStructure<String>> roomnonotfoundexception(Roomnonotfoundexception ex) {
		responseStructure.setMessage("room no not found");
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setData(ex.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(Roomavailabilitynotfoundexception.class)
	public ResponseEntity<ResponseStructure<String>> roomavailabilitynotfoundexception(Roomavailabilitynotfoundexception ex) {
		responseStructure.setMessage("room availability not found");
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setData(ex.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
	}
		
}
