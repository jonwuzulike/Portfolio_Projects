package com.ers.dao;

import java.util.ArrayList;

import com.ers.models.Reimbursement;

public interface ReimbursementDAO {
	
	//Get all reimbursements.
	public ArrayList<Reimbursement> getAll();
	
	//Gets reimbursements by id.
	public ArrayList<Reimbursement> getByUser(int id);
	
	//Get a single reimbursement.
	//public Reimbursement getOne(int id);
	

}
