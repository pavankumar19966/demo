package com.customer.service;


import java.util.Date;
import java.util.List;

import org.slf4j.Logger;


import org.slf4j.LoggerFactory;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.customer.Repository.CustomerDaoRepository;
import com.customer.dao.Customerdao;
import com.customer.exception.CustomerInputException;
import com.customer.exception.ResourceNotFoundException;
import com.customer.model.Customerdetails;
import com.customer.response.Response;
import com.customer.response.StatusCode;



@Service
public class CustomerServiceImplementation implements CustomerService{
	@Autowired
    CustomerDaoRepository customerdaoRepository;
	@Autowired
	 Customerdao customerDao;
	
	private static final Logger logger = LoggerFactory.getLogger(CustomerServiceImplementation.class);
     //add

	@Override
	public Response addCustomer(Customerdetails customerdetails) throws Exception {
		Response response=new Response();
		
		logger.info("inside userservice");
		if(customerdetails==null)
		{    
			response.setMessage("please provide userdetail");
			return response;
		}
		else
		{
			Customerdetails customerdetail=new Customerdetails();
			
			response=customerDao.addCustomer(customerdetails);
			return response;
		}
	
	
	
	}

	@Override
	public Response getById(int customerId) {
		try
		{
		    Customerdetails details=new Customerdetails();
			Response response=new Response();
			
			response= customerDao.getById(customerId);
			if(response.getData()!=null)
			{
			logger.info("formid taken,inside getByemailservice");
			details=(Customerdetails)response.getData();
		
			response.setData(details);
			return response;
			}
			else
			{
				throw new ResourceNotFoundException();
			}
			
		
		}
		catch(ResourceNotFoundException e)
		{
			logger.error("resource notfound" );
			Response response=new Response(StatusCode.ERROR, "id not matched with any case", e.getMessage().toString(), new Date());
		return response;
		}
		catch(Exception e)
		{
			logger.error("please provide id" );
			Response response=new Response(StatusCode.ERROR, "please provide form id", e.getMessage().toString(), new Date());
			return response;
		}
		
		

	}

	@Override
	public List<Customerdetails> getAllDetails() {

		
	    List<Customerdetails> details= customerDao.getAllDetails();
		return details;
	   
	}

	@Override
	public Response deleteByIdCustomer(int customerId) {
		try
		{
		if(customerId==0)
		{
			throw new CustomerInputException();
		} 
			logger.info("customer id taken,inside deleteBycustomeridservice");
	         return customerDao.deleteByIdCustomer(customerId);
		}
		catch(CustomerInputException e)
		{
			logger.error("request without input,inside deletebycustomeridservice" );
			Response response=new Response(StatusCode.ERROR, "please enter your customerid", e.getMessage().toString(), new Date());
		return response;
		}
	}

	@Override
	public Response updateCustomer(Customerdetails customerdetails, int customerId) {
		logger.info("inside updatecustomerervice" );
		Response response=new Response();
		try
		{
			if(customerdetails!=null)
			{
				
				return customerDao.updateCustomer(customerdetails, customerId);
			}
			else
			{
				throw new CustomerInputException();
			}
		}
		catch(NullPointerException e)
		{
			
			return response;
		}
		catch(CustomerInputException e)
		{   logger.error("inside updatecustomerservice",e);
			Response response1=new Response(StatusCode.ERROR, "kindly fill your details", e.getMessage().toString(), new Date());
			return response1;
		}
	}
}



	
		


	
	
