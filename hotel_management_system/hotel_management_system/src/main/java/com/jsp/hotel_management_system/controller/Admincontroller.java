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

import com.jsp.hotel_management_system.dto.Admin;
import com.jsp.hotel_management_system.service.Adminservice;
import com.jsp.hotel_management_system.util.ResponseStructure;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/admin")
public class Admincontroller {

	@Autowired
	private Adminservice adminservice;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Admin>> saveadmin(@Valid @RequestBody Admin admin,@RequestParam int hid) {
		return adminservice.saveadmin(admin, hid);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<Admin>> updateadmin(@Valid @RequestParam int aid,@RequestBody Admin admin) {
		return adminservice.updateadmin(admin, aid);
	}
	
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Admin>> deleteadmin(@Valid @RequestParam int aid) {
		return adminservice.deleteadmin(aid);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<Admin>> getadminbyid(@Valid @RequestParam int aid) {
		return adminservice.getadminbyid(aid);
		
	}
	
	@GetMapping("/getalladmin")
	public ResponseEntity<ResponseStructure<List<Admin>>> getalladmin() {
		return adminservice.getalladmin();
	}
	
	@GetMapping("/loginadmin")
	public ResponseEntity<ResponseStructure<Admin>> loginadmin(@Valid @RequestParam String email,@RequestParam String password) {
		return adminservice.loginadmin(email, password);
	}
	

}
