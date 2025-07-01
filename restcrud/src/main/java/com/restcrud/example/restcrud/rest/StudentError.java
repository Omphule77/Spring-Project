package com.restcrud.example.restcrud.rest;

public class StudentError {

	private int status;
	private String massage;
	private long timeStamp;
	
	public StudentError()
	{
		
	}
	
	public StudentError(int status, String massage, long timeStamp) {
		super();
		this.status = status;
		this.massage = massage;
		this.timeStamp = timeStamp;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMassage() {
		return massage;
	}

	public void setMassage(String massage) {
		this.massage = massage;
	}

	public long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}

	@Override
	public String toString() {
		return "StudentError [status=" + status + ", massage=" + massage + ", timeStamp=" + timeStamp + "]";
	}
	
	
	
	
}
