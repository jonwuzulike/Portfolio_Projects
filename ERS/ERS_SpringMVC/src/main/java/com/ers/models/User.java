package com.ers.models;

import java.io.Serializable;
import java.math.BigDecimal;


public class User implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8360003932966450765L;
	
	private int id;
	private String first;
	private String last;
	private String email;
	private int userTypeId;
	
	public User() {
		
	}

	public User(int id, String first, String last, String email, int userTypeId) {
		super();
		this.id = id;
		this.first = first;
		this.last = last;
		this.email = email;
		this.userTypeId = userTypeId;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getFirst() {
		return first;
	}



	public void setFirst(String first) {
		this.first = first;
	}



	public String getLast() {
		return last;
	}



	public void setLast(String last) {
		this.last = last;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public int getUserTypeId() {
		return userTypeId;
	}



	public void setUserTypeId(int userTypeId) {
		this.userTypeId = userTypeId;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", first=" + first + ", last=" + last + ", email=" + email + ", userTypeId="
				+ userTypeId + "]";
	}
	
 
	
}
