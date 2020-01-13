package com.customer.controller;

import java.util.List;









import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.customer.Repository.CustomerDaoRepository;

import com.customer.model.Customerdetails;
import com.customer.response.Response;
import com.customer.service.CustomerService;




@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	CustomerService customerService;
public static final Logger logger=LoggerFactory.getLogger(CustomerController.class);
	
	
	@PostMapping("/addCustomer")
	public @ResponseBody Response addCustomer(@RequestBody Customerdetails customerdetails,HttpServletRequest request) throws Exception
	{

		logger.info("addemployee: Received request URL: " + request.getRequestURL().toString()
				+ ((request.getQueryString() == null) ? "" : "?" + request.getQueryString().toString()));
		return customerService.addCustomer(customerdetails);
		
	}
	@GetMapping("/getcustomerdetails/{customerId}")
	   public @ResponseBody Response getById(@PathVariable int customerId,HttpServletRequest request)
	   {
		   logger.info("getbyid: Received request URL: " + request.getRequestURL().toString()
					+ ((request.getQueryString() == null) ? "" : "?" + request.getQueryString().toString()));
		   return customerService.getById(customerId);
		   
		   
	   }
	@GetMapping("/listofcustomerdetails/getcustomerdetails")
	   public @ResponseBody List<Customerdetails> getAllDetails(HttpServletRequest request)
	   {
		   logger.info("getcustomerdetails: Received request URL: " + request.getRequestURL().toString()
					+ ((request.getQueryString() == null) ? "" : "?" + request.getQueryString().toString()));
		   return customerService.getAllDetails();
		   
		   
	   }
	@DeleteMapping("/deletebycustomerid/{customerId}")
	   public @ResponseBody Response deleteByIdCustomer(@PathVariable int customerId,HttpServletRequest request)
	   {
		   logger.info("addcustomer: Received request URL: " + request.getRequestURL().toString()
					+ ((request.getQueryString() == null) ? "" : "?" + request.getQueryString().toString()));
		   return customerService.deleteByIdCustomer(customerId);
	   }
	
	
	 @PutMapping("/updatecustomer/{customerId}")
	   public @ResponseBody Response updateCustomer(@RequestBody Customerdetails customerdetails,@PathVariable int customerId,HttpServletRequest request)
	   {
		   logger.info("addcustomer: Received request URL: " + request.getRequestURL().toString()
					+ ((request.getQueryString() == null) ? "" : "?" + request.getQueryString().toString()));
		   return customerService.updateCustomer(customerdetails, customerId);
	   }
}
	
	

