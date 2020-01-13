package com.customer.exception;

public class CustomerInputException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		
		return "invalid input";
	}
	

}
