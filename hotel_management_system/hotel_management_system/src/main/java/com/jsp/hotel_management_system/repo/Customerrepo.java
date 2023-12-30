package com.jsp.hotel_management_system.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jsp.hotel_management_system.dto.Customer;

public interface Customerrepo extends JpaRepository<Customer, Integer> {
	
	@Query("select c from Customer c where c.customer_email=?1")
	public Customer getcustomerbyemail(String customer_email) ;

}
