 package com.customer.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity

@Table(name="customerdetails")

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Customerdetails {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="customerid")
	private int customerid;
	
	
	@Column(name="customername")
	
	private String customername;


	public int getCustomerid() {
		return customerid;
	}


	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}


	public String getCustomername() {
		return customername;
	}


	public void setCustomername(String customername) {
		this.customername = customername;
	}

	
}