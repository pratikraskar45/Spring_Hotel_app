package com.jsp.hotel_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.hotel_management_system.dao.Customerdao;
import com.jsp.hotel_management_system.dto.Customer;
import com.jsp.hotel_management_system.exception.Allcustomernotfoundexception;
import com.jsp.hotel_management_system.exception.Emailnotfoundexception;
import com.jsp.hotel_management_system.exception.Idnotfoundexception;
import com.jsp.hotel_management_system.exception.Logincustomernotfoundexception;
import com.jsp.hotel_management_system.util.ResponseStructure;

@Service
public class Customerservice {
	
	@Autowired
	private Customerdao customerdao;
	
	ResponseStructure<Customer> responseStructure=new ResponseStructure<Customer>();
	
	public ResponseEntity<ResponseStructure<Customer>> savecustomer(Customer customer) {
		Customer dbCustomer=customerdao.saveCustomer(customer);
		if (dbCustomer!=null) {
			responseStructure.setMessage("Customer saved succesfully");
			responseStructure.setStatus(HttpStatus.CREATED.value());
			responseStructure.setData(dbCustomer);
			return new ResponseEntity<ResponseStructure<Customer>>(responseStructure,HttpStatus.CREATED);
			
		} else {
			return null;

		}
		
	}
	public ResponseEntity<ResponseStructure<Customer>> updatecustomer(int cid ,Customer customer) {
		Customer dbCustomer=customerdao.getCustomerbyid(cid);
		if (dbCustomer!=null) {
			customer.setCustomer_id(cid);
			responseStructure.setMessage("Customer updated succesfully");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(customerdao.updateCustomer(customer));
			return new ResponseEntity<ResponseStructure<Customer>>(responseStructure,HttpStatus.OK);
			
		} else {
			throw new Idnotfoundexception();

		}
		
	}
	public ResponseEntity<ResponseStructure<Customer>> deletecustomer(int cid) {
		Customer customer=customerdao.getCustomerbyid(cid);
		if (customer!=null) {
			responseStructure.setMessage("Customer deleted succesfully");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(customerdao.deleteCustomer(customer));
			return new ResponseEntity<ResponseStructure<Customer>>(responseStructure,HttpStatus.OK);	
		} else {
			throw new Idnotfoundexception();
		}
	}
	public ResponseEntity<ResponseStructure<Customer>> getcustomerbyid(int cid) {
		Customer customer=customerdao.getCustomerbyid(cid);
		if (customer!=null) {
			responseStructure.setMessage("Customer found succesfully");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(customer);
			return new ResponseEntity<ResponseStructure<Customer>>(responseStructure,HttpStatus.FOUND);
			
		} else {
			throw new Idnotfoundexception();

		}
	}
	
	public ResponseEntity<ResponseStructure<Customer>> getcustomerbyemail(String email) {
		Customer customer=customerdao.getCustomerbyemail(email);
		if (customer!=null) {
			responseStructure.setMessage("Customer found succesfully");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(customer);
			return new ResponseEntity<ResponseStructure<Customer>>(responseStructure,HttpStatus.FOUND);	
		} else {
			throw new Emailnotfoundexception();
		}
	}
	
	public ResponseEntity<ResponseStructure<Customer>> logincustomer(String email,String password) {
		Customer customer=customerdao.getCustomerbyemail(email);
		if (customer.getCustomer_password().equals(password)) {
			responseStructure.setMessage("Customer login succesfully");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(customer);
			return new ResponseEntity<ResponseStructure<Customer>>(responseStructure,HttpStatus.OK);	
		} else {
			
			throw new Logincustomernotfoundexception();
//			responseStructure.setMessage("enter the valid email and password");
//			responseStructure.setStatus(HttpStatus.BAD_REQUEST.value());
//			responseStructure.setData(null);
//			return new ResponseEntity<ResponseStructure<Customer>>(responseStructure,HttpStatus.BAD_REQUEST);
		}
	}
	
	
	public ResponseEntity<ResponseStructure<List<Customer>>> getallcustomer() {
		ResponseStructure<List<Customer>> responseStructure=new ResponseStructure<>();
		if (customerdao.getallCustomers()!=null) {
			responseStructure.setMessage("Found succesfully");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(customerdao.getallCustomers());
			
			return new ResponseEntity<ResponseStructure<List<Customer>>>(responseStructure,HttpStatus.FOUND);
		} else {
			throw new Allcustomernotfoundexception();

		}
	}
	
	
	
}
