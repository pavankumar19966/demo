package com.customer.dao;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.customer.Repository.CustomerDaoRepository;
import com.customer.exception.ResourceNotFoundException;
import com.customer.model.Customerdetails;
import com.customer.response.Response;
import com.customer.response.StatusCode;









@Transactional
@Repository
public class CustomerDaoImplementation implements Customerdao {
	@Autowired
    CustomerDaoRepository customerdaoRepository;
	public static final Logger logger=LoggerFactory.getLogger(CustomerDaoImplementation.class);

	
	@Override
	public Response addCustomer(Customerdetails customerdetails) {
		
		try
		{
			logger.info("inside userdao");
			customerdaoRepository.saveAndFlush(customerdetails);
			Response response=new Response(StatusCode.SUCCESS, "customer information collected", null, new Date());
			
			return response;
			
		}
		catch(Exception e)
		{
			logger.error("inside userdao");
			Response response=new Response(StatusCode.ERROR, "customer information not collected pl try again", e.getMessage().toString(), new Date());
		     return response;
		}
		
	}


	@Override
	public Response getById(int customerId) {
		try 
		{
			logger.info("inside getbycontactdao");
			Customerdetails details= customerdaoRepository.findById(customerId);
			Response response=new Response(StatusCode.SUCCESS, "requested user detail", details, null, new Date());
			
			return response;
		
		}
		
		catch(Exception e) {
			Response response=new Response();
			response.setData(null);
			return response;
		
		}

	}


	@Override
	public List<Customerdetails> getAllDetails() {
		try
		{
		  return customerdaoRepository.findAll();
		}
		catch(Exception e)
		{
			logger.error("inside getallDetails()DAO",e);
			return null;
		}
	}


	@Override
	public Response deleteByIdCustomer(int customerId) {
		try 
		{
			logger.info("inside deletebyiddao");
			Customerdetails details=customerdaoRepository.findById(customerId);
			if(details!=null)
			{
			customerdaoRepository.delete(details);
			 Response response=new Response(StatusCode.SUCCESS, "id"+" "+"deleted successfully", null, null, new Date());
			 return response;
			}
			else
			{
				throw new ResourceNotFoundException();
			}
		}
		catch(ResourceNotFoundException e)
		{
			Response response=new Response(StatusCode.ERROR, "please enter valid  id", e.getMessage().toString(), new Date());
			return response;
		}
		catch(Exception e) {
			logger.error("not deleted", e);
			Response response=new Response();
			response.setError(e.getMessage().toString());
			response.setStatus(StatusCode.ERROR);
			response.setTimeStamp(new Date());
			return response;
		
		}
	}


	@Override
	public Response updateCustomer(Customerdetails customerdetails, int customerId) {
		try
		{
			logger.info("inside updatecustomerdao");
		Customerdetails details=new Customerdetails();
			details=customerdaoRepository.findById(customerId);
			
			if(details!=null)
			{
				
				logger.info("id matched in database");
				details.setCustomername(customerdetails.getCustomername());
				
			
			customerdaoRepository.saveAndFlush(customerdetails);
			Response response=new Response(StatusCode.SUCCESS, "customerdetails updated", null, new Date());
			
			return response;
			}
			else
			{
				logger.info("id not matched");
				throw new ResourceNotFoundException();
			}
			
		}
		catch(ResourceNotFoundException e)
		{
			Response response=new Response();
			logger.error("inside updatecustomerdao", e);
			response.setError(e.getMessage().toString());
			response.setMessage("not matched with any id ");
			response.setStatus(StatusCode.ERROR);
			response.setTimeStamp(new Date());
			return response;
		}
		
		catch(Exception e)
		{
			logger.error("inside customerdao");
			Response response=new Response(StatusCode.ERROR, "customerdetails not updated", e.getMessage().toString(), new Date());
		     return response;
		}

	}
}

	


	
	


	

	
	
	
	
	
	
	