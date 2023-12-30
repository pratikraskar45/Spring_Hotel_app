package com.jsp.HotelManagementSystem.exception;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.jsp.HotelManagementSystem.util.Responsestructure;

@ControllerAdvice
public class Applicationexceptionhandler extends ResponseEntityExceptionHandler{

	Responsestructure<String> responsestructure=new Responsestructure<>();
	
	@ExceptionHandler(Idnotfoundexception.class)
	public ResponseEntity<Responsestructure<String>> idnotfoundexception(Idnotfoundexception ex) {
		responsestructure.setMessage("id not found");
		responsestructure.setStatus(HttpStatus.NOT_FOUND.value());
		responsestructure.setData(ex.getMessage());
		return new ResponseEntity<Responsestructure<String>>(responsestructure,HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<Responsestructure<String>> nosuchelementexception(NoSuchElementException ex) {
		responsestructure.setMessage("no element found");
		responsestructure.setStatus(HttpStatus.NOT_FOUND.value());
		responsestructure.setData(ex.getMessage());
		return new ResponseEntity<Responsestructure<String>>(responsestructure,HttpStatus.NOT_FOUND);

		
	}
	
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<ObjectError> list=ex.getAllErrors();
		Map<String, String> map=new LinkedHashMap<>();
		for(ObjectError error:list) {
			String fieldname=((FieldError)error).getField();
			String message=((FieldError)error).getDefaultMessage();
			map.put(fieldname, message);
		}
		return new ResponseEntity<Object>(map,HttpStatus.BAD_REQUEST);
			
		}
		
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<Responsestructure<String>> handleconstraintviolationexception(ConstraintViolationException ex) {
		responsestructure.setMessage(ex.getMessage());
		responsestructure.setData("this field cannot be null or blank");
		responsestructure.setStatus(HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<Responsestructure<String>>(responsestructure,HttpStatus.BAD_REQUEST);		
	}
	
	
	@ExceptionHandler(Maxnumberpeopleexception.class)
	public ResponseEntity<Responsestructure<String>> maxnumberpeoplexception(Maxnumberpeopleexception ex) {
		responsestructure.setMessage("max limit of people for the particular room");
		responsestructure.setStatus(HttpStatus.BAD_REQUEST.value());
		responsestructure.setData(ex.getMessage());
		return new ResponseEntity<Responsestructure<String>>(responsestructure,HttpStatus.BAD_REQUEST);		

	}
}

