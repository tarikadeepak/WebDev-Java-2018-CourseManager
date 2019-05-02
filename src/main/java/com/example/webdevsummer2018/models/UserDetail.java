package com.example.webdevsummer2018.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import hashing.HashPassword;

@Entity
public class UserDetail {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String email;
	private String password;
	private String firstName;
	private String lastName;
	private String typeOfUser;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		try {
			this.password = (new HashPassword().hashPassword(password));
		}
		catch(Exception e) {
			System.out.println("Error in Hashing Password " +  e.getMessage());
		}
	}
	public UserDetail() {
		super();
	}
	
	public UserDetail(String email, String password, String firstName, String lastName, String typeOfUser) {
		super();
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.typeOfUser = typeOfUser;
	}
	@Override
	public String toString() {
		return "UserDetail [email=" + email + ", password=" + password + ", firstName=" + firstName + ", lastName="
				+ lastName + ", typeOfUser=" + typeOfUser + "]";
	}
	public String getTypeOfUser() {
		return typeOfUser;
	}
	public void setTypeOfUser(String typeOfUser) {
		this.typeOfUser = typeOfUser;
	}
	
}
