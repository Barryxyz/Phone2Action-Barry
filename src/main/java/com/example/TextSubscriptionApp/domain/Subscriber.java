package com.example.TextSubscriptionApp.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Repository;


@Repository
@Document(collection = "Subscribers")
public class Subscriber {
	public String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	
	public Subscriber() {
		
	}

	public Subscriber(String firstName, String lastName, String email, String phoneNumber) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public boolean valid() {
		if(this.firstName == null || this.lastName == null || this.email == null || this.phoneNumber == null) {
			return false;
		}
		return true;
	}
	
	public boolean validPhoneNumber() {
        String regex = "^[1-9]{10}$"; 
        
        return this.phoneNumber.matches(regex);
	}
}
