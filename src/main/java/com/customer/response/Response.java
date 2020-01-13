package com.customer.response;

import java.util.ArrayList;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value = Include.NON_NULL)
public class Response {
	private StatusCode status;
	private String message;
	private Object data;
	private Object error;
	private Date timeStamp;
	public StatusCode getStatus() {
		return status;
	}
	public void setStatus(StatusCode status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public Object getError() {
		return error;
	}
	public void setError(Object error) {
		this.error = error;
	}
	public Date getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
	public Response(StatusCode status, String message, Object data, Object error, Date timeStamp) {
		super();
		this.status = status;
		this.message = message;
		this.data = data;
		this.error = error;
		this.timeStamp = timeStamp;
	}
	public Response(StatusCode status, String message, Object error, Date timeStamp) {
		super();
		this.status = status;
		this.message = message;
		this.error = error;
		this.timeStamp = timeStamp;
	}
	public Response() {
		super();
		
	}
	

}
