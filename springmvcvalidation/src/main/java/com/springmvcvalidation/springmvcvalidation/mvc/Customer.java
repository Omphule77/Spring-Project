package com.springmvcvalidation.springmvcvalidation.mvc;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class Customer {

	private String firstName;
	
	@NotNull(message = "is required")
	@Size(min=1,message = "is required")
	private String lastName;
	
	@NotNull(message = "is required")
	@Min(value=0,message="Must be greater than zero")
	@Max(value = 10,message = "Must be smaller than 10")
	private Integer freePasses;
	
	
	@Pattern(regexp="^[a-zA-Z0-9]{5}",message="Only 5 chars/digits")
	private String postCode;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getFreePasses() {
		return freePasses;
	}

	public void setFreePasses(Integer freePasses) {
		this.freePasses = freePasses;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	
	
	
	
	
}
