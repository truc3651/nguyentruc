package com.test.model;

public class ContactForm {
	private String fullname = "";
	private String email = "";
	private String phoneNumber = "";
	private String message = "";
	
	public ContactForm() {
		super();
	}

	public ContactForm(String fullname, String email, String phoneNumber, String message) {
		super();
		this.fullname = fullname;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.message = message;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
