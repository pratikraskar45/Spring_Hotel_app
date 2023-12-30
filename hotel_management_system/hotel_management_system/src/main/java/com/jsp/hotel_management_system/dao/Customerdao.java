package com.jsp.hotel_management_system.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.hotel_management_system.dto.Customer;
import com.jsp.hotel_management_system.repo.Customerrepo;
@Repository
public class Customerdao {
	@Autowired
	private Customerrepo customerrepo;
	
	public Customer saveCustomer(Customer customer) {
		return  customerrepo.save(customer);
		
	}
	public Customer updateCustomer(Customer customer) {
		return customerrepo.save(customer);
	}

	public Customer deleteCustomer(Customer customer) {
		customerrepo.delete(customer);
		return customer;
	}

	public Customer getCustomerbyid(int cid) {
		if (customerrepo.findById(cid).isPresent()) {
			return customerrepo.findById(cid).get();
		} else {
			return null;
		}
	}

	public Customer getCustomerbyemail(String customer_email) {
		if (customerrepo.getcustomerbyemail(customer_email)!=null) {
			return customerrepo.getcustomerbyemail(customer_email);
			
		} else {
			return null;

		}
		
		
		}
	public List<Customer> getallCustomers() {
		return customerrepo.findAll();
		
	}

}
