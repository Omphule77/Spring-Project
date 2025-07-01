package com.thymeleafdemo.thymeleafdemo.model;

import java.util.List;

public class Student {

	private String firstName;
	private String lastName;
	private String country;
	private String favsub;
	private List<String> favops;

	public Student() {

	}

	public Student(String firstName, String lastName, String country, String favsub, List<String> favops) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.country = country;
		this.favsub = favsub;
		this.favops = favops;
	}

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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getFavsub() {
		return favsub;
	}

	public void setFavsub(String favsub) {
		this.favsub = favsub;
	}

	public List<String> getFavops() {
		return favops;
	}

	public void setFavops(List<String> favops) {
		this.favops = favops;
	}

	@Override
	public String toString() {
		return "Student [firstName=" + firstName + ", lastName=" + lastName + ", country=" + country + ", favsub="
				+ favsub + ", favops=" + favops + "]";
	}

}
