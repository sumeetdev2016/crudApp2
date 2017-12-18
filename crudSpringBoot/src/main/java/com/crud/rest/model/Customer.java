package com.crud.rest.model;

public class Customer {
	private int id;
	private String firstname;
	private String lastname;
	private String phonenumber;
	
	public Customer(){
	}
	
	public Customer(String firstname, String lastname, String phoneNumber){
		this.firstname = firstname;
		this.lastname = lastname;
		this.phonenumber = phoneNumber; 
	}
	
	public Customer(int id, String firstname, String lastname, String phoneNumber){
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.phonenumber = phoneNumber;
	}
	
	// id
	public void setId(int id){
		this.id = id;
	}
	
	public int getId(){
		return this.id;
	}
	
	// firstname
	public void setFirstname(String firstname){
		this.firstname = firstname;
	}
	
	public String getFirstname(){
		return this.firstname;
	}
	
	// lastname
	public void setLastname(String lastname){
		this.lastname = lastname;
	}
	
	public String getLastname(){
		return this.lastname;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	
}
