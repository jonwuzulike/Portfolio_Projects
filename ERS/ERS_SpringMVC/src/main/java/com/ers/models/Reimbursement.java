package com.ers.models;

import java.io.Serializable;

public class Reimbursement implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 975019376274486932L;
	private int rId;
	private String name;
	private double amount;
	private int rStatusId;
	private int rTypeId;
	private int userId;
	private String date;
	
	
	public Reimbursement() {
		super();
	}


	public Reimbursement(int rId, String name, double amount, int rStatusId, int rTypeId, int userId, String date) {
		super();
		this.rId = rId;
		this.name = name;
		this.amount = amount;
		this.rStatusId = rStatusId;
		this.rTypeId = rTypeId;
		this.userId = userId;
		this.date = date;
	}


	public int getrId() {
		return rId;
	}


	public void setrId(int rId) {
		this.rId = rId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	public int getrStatusId() {
		return rStatusId;
	}


	public void setrStatusId(int rStatusId) {
		this.rStatusId = rStatusId;
	}


	public int getrTypeId() {
		return rTypeId;
	}


	public void setrTypeId(int rTypeId) {
		this.rTypeId = rTypeId;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	@Override
	public String toString() {
		return "Reimbursement [rId=" + rId + ", name=" + name + ", amount=" + amount + ", rStatusId=" + rStatusId
				+ ", rTypeId=" + rTypeId + ", userId=" + userId + ", date=" + date + "]";
	}
	
	
	

}
