package com.customer.dao;

import java.util.List;
 


import java.util.Optional;

import com.customer.model.Customerdetails;
import com.customer.response.Response;



public interface Customerdao {
	 Response addCustomer(Customerdetails customerdetails)throws Exception;
	 Response getById(int customerId);
	 List<Customerdetails> getAllDetails();
	 Response deleteByIdCustomer(int customerId);
	 Response updateCustomer(Customerdetails customerdetails, int customerId);


}
