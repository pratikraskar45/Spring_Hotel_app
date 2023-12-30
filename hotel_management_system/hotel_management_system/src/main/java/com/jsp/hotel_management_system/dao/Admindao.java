package com.jsp.hotel_management_system.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.hotel_management_system.dto.Admin;
import com.jsp.hotel_management_system.repo.Adminrepo;
@Repository
public class Admindao {
	@Autowired
	private Adminrepo adminrepo;
	
	
	public Admin saveAdmin(Admin admin) {
		return adminrepo.save(admin);
	}
	
	public Admin updateAdmin(Admin admin) {
		return adminrepo.save(admin);
	}
	
	
	public Admin deleteAdmin(Admin admin) {
		adminrepo.delete(admin);
		return admin;
	}
	
//	public Admin deleteAdmin(int aid) {
//		if(adminrepo.findById(aid).isPresent()) {
//			Admin admin=adminrepo.findById(aid).get();
//			adminrepo.delete(admin);
//			return admin;
//		}else {
//			return null;
//		}
//	}
	
	public Admin getAdminbyid(int aid) {
		if(adminrepo.findById(aid).isPresent()) {
			return adminrepo.findById(aid).get();
		}else {
			return null;
		}
	}
	public List<Admin>getalladmin() {
		return adminrepo.findAll();
		
	}
	public Admin getAdminbyemail(String admin_email) {
		if (adminrepo.getAdminbyemail(admin_email)!=null) {
			return adminrepo.getAdminbyemail(admin_email);
			
		} else {
			return null;

		}
		
	}

}
