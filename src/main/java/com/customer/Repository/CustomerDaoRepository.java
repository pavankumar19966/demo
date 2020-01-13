package com.customer.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


import com.customer.model.Customerdetails;
import com.customer.response.Response;
@Repository
public interface CustomerDaoRepository extends JpaRepository<Customerdetails, Integer>{
	Customerdetails deleteById(int customerId);
	   void deleteAll();
	   Customerdetails findById(int customerId);
	    
}
