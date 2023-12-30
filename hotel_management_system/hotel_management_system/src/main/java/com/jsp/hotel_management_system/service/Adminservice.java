package com.jsp.hotel_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.hotel_management_system.dao.Admindao;
import com.jsp.hotel_management_system.dao.Hoteldao;
import com.jsp.hotel_management_system.dto.Admin;
import com.jsp.hotel_management_system.dto.Hotel;
import com.jsp.hotel_management_system.exception.Alladminnotfoundexception;
import com.jsp.hotel_management_system.exception.Emailnotfoundexception;
import com.jsp.hotel_management_system.exception.Idnotfoundexception;
import com.jsp.hotel_management_system.exception.Loginadminnotfoundexception;
import com.jsp.hotel_management_system.util.ResponseStructure;

@Service

public class Adminservice {
	@Autowired
	private Admindao admindao;
	
	@Autowired
	private Hoteldao hoteldao;
	
	ResponseStructure<Admin> responseStructure=new ResponseStructure<>();
	
	public ResponseEntity<ResponseStructure<Admin>> saveadmin(Admin admin,int hid) {
		Hotel hotel=hoteldao.getHotelbyid(hid);
		admin.setHotel(hotel);
		Admin dbAdmin=admindao.saveAdmin(admin);
		
		if(dbAdmin!=null) {
			responseStructure.setMessage("admin saved succesfully");
			responseStructure.setStatus(HttpStatus.CREATED.value());
			responseStructure.setData(dbAdmin);
			return new ResponseEntity<ResponseStructure<Admin>>(responseStructure,HttpStatus.CREATED);
		}else {
			return null;
		}
	}
	
	public ResponseEntity<ResponseStructure<Admin>> updateadmin(Admin admin,int aid) {
		Admin admin2=admindao.getAdminbyid(aid);
		admin.setHotel(admin2.getHotel());
		if(admin2!=null) {
			admin.setAdmin_id(aid);
			responseStructure.setMessage("admin updated succesfully");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(admindao.updateAdmin(admin));
			return new ResponseEntity<ResponseStructure<Admin>>(responseStructure,HttpStatus.OK);
		}else {
			throw new Idnotfoundexception();
		}
	}
	public ResponseEntity<ResponseStructure<Admin>> deleteadmin(int aid) {
		Admin admin=admindao.getAdminbyid(aid);
		if(admin!=null) {
			responseStructure.setMessage("admin deleted succesfully");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(admindao.deleteAdmin(admin));
			return new ResponseEntity<ResponseStructure<Admin>>(responseStructure,HttpStatus.OK);
		}else {
			throw new Idnotfoundexception();
		}
	}
	
	public ResponseEntity<ResponseStructure<Admin>>  getadminbyid(int aid) {
		Admin admin=admindao.getAdminbyid(aid);
		if(admin!=null) {
			responseStructure.setMessage("admin found succesfully");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(admin);
			return new ResponseEntity<ResponseStructure<Admin>>(responseStructure,HttpStatus.FOUND);

		}else {
			throw new Idnotfoundexception();
		}
	}
	
	public ResponseEntity<ResponseStructure<Admin>> getadminbyemail(String admin_email) {
		Admin admin=admindao.getAdminbyemail(admin_email);
		if(admin!=null) {
			responseStructure.setMessage("admin found succesfully");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(admin);
			return new ResponseEntity<ResponseStructure<Admin>>(responseStructure,HttpStatus.FOUND);
		}else {
			throw new Emailnotfoundexception();
		}
	}
	
	public ResponseEntity<ResponseStructure<Admin>> loginadmin(String admin_email,String admin_password) {
		Admin admin=admindao.getAdminbyemail(admin_email);
		if(admin.getAdmin_password().equals(admin_password)) {
			responseStructure.setMessage("admin logged in succesfully");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(admin);
			return new ResponseEntity<ResponseStructure<Admin>>(responseStructure,HttpStatus.OK);
		}else {
			
//			responseStructure.setMessage("enter valid email and password");
//			responseStructure.setStatus(HttpStatus.BAD_REQUEST.value());
//			responseStructure.setData(null);
//			return new ResponseEntity<ResponseStructure<Admin>>(responseStructure,HttpStatus.BAD_REQUEST);
			throw new Loginadminnotfoundexception();
		}
		
	}
	
	public ResponseEntity<ResponseStructure<List<Admin>>> getalladmin() {
		ResponseStructure<List<Admin>> responseStructure=new ResponseStructure<>();
		if(admindao.getalladmin()!=null) {
			responseStructure.setMessage("found succesfully");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(admindao.getalladmin());
			return new ResponseEntity<ResponseStructure<List<Admin>>>(responseStructure,HttpStatus.FOUND);
		}else {
			throw new Alladminnotfoundexception();
		}

	
	
	}
}

	

