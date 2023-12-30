package com.jsp.HotelManagementSystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jsp.HotelManagementSystem.dto.Admin;

public interface Adminrepo extends JpaRepository<Admin, Integer>{

	@Query("select a from Admin a where a.admin_email=?1")
	public Admin getAdminbyemail(String admin_email) ;
}
