package com.ers.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ers.dao.ReimbursementDAO;
import com.ers.models.Reimbursement;

@RestController
public class ReimbursementController {
	@Autowired
	private ReimbursementDAO dao;
	
	
	@RequestMapping(value="/reimbursements")
	public ArrayList<Reimbursement> getAllReimbursements() {
		System.out.println("In ReimbursementController --- All Reimbursements");
		return dao.getAll();
	}
	
	@RequestMapping(value = "/reimbursement/user")
	public ArrayList<Reimbursement> getById(@RequestParam int id) {
		System.out.println("In ReimbursementController --- Single Reimbursement");
		return dao.getByUser(id);
	}
}
