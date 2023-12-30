package com.jsp.hotel_management_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.hotel_management_system.dto.Customer;
import com.jsp.hotel_management_system.service.Customerservice;
import com.jsp.hotel_management_system.util.ResponseStructure;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/customer")
public class Customercontroller {

	@Autowired
	private Customerservice customerservice;

	@PostMapping
	public ResponseEntity<ResponseStructure<Customer>> savecustomer(@Valid @RequestBody Customer customer) {
		return customerservice.savecustomer(customer);
	}

	@PutMapping
	public ResponseEntity<ResponseStructure<Customer>> updatecustomer(@Valid @RequestParam int cid,
			@RequestBody Customer customer) {
		return customerservice.updatecustomer(cid, customer);
	}

	@DeleteMapping
	public ResponseEntity<ResponseStructure<Customer>> deletecustomer(@Valid @RequestParam int cid) {
		return customerservice.deletecustomer(cid);
	}

	@GetMapping
	public ResponseEntity<ResponseStructure<Customer>> getcustomerbyid(@Valid @RequestParam int cid) {
		return customerservice.getcustomerbyid(cid);
	}

	@GetMapping("/customerbyemail")
	public ResponseEntity<ResponseStructure<Customer>> getcustomerbyemail(@Valid @RequestParam String customer_email) {
		return customerservice.getcustomerbyemail(customer_email);
	}

	@GetMapping("/customerlogin")
	public ResponseEntity<ResponseStructure<Customer>> logincustomer(@Valid @RequestParam String email,
			@RequestParam String password) {
		return customerservice.logincustomer(email, password);
	}

	@GetMapping("/getall")
	public ResponseEntity<ResponseStructure<List<Customer>>> getallcustomer() {
		return customerservice.getallcustomer();
	}

}
