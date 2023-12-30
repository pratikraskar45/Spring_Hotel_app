package com.jsp.HotelManagementSystem.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.jsp.HotelManagementSystem.dto.Admin;
import com.jsp.HotelManagementSystem.service.Adminservice;
import com.jsp.HotelManagementSystem.util.Responsestructure;

@RestController
@RequestMapping("/admin")
public class Admincontroller {

	@Autowired
	private Adminservice adminservice;

	@PostMapping
	public ResponseEntity<Responsestructure<Admin>> saveAdmin(@Valid @RequestBody Admin admin, @RequestParam int hid) {
		return adminservice.saveAdmin(admin, hid);

	}

	@PutMapping
	public ResponseEntity<Responsestructure<Admin>> updateAdmin(@Valid @RequestBody Admin admin, @RequestParam int aid) {
		return adminservice.updateAdmin(aid, admin);

	}

	@DeleteMapping
	public ResponseEntity<Responsestructure<Admin>> deleteAdmin(@Valid @RequestParam int aid) {
		return adminservice.deleteAdmin(aid);

	}

	@GetMapping("/adminbyid")
	public ResponseEntity<Responsestructure<Admin>> getAdminbyid(@Valid @RequestParam int aid) {
		return adminservice.getAdminbyid(aid);

	}

	@GetMapping("/adminbyemail")
	public ResponseEntity<Responsestructure<Admin>> getAdminbyemail(@Valid @RequestParam String email) {
		return adminservice.getadminbyemail(email);

	}

	@GetMapping("/getalladmin")
	public ResponseEntity<Responsestructure<List<Admin>>> getallAdmin() {
		return adminservice.getallAdmin();
	}

	@GetMapping("/loginadmin")
	public ResponseEntity<Responsestructure<Admin>> loginAdmin(@Valid @RequestParam String email, @RequestParam String password) {
		return adminservice.loginAdmin(email, password);

	}
}
