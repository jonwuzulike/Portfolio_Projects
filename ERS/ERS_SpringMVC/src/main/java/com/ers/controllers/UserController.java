package com.ers.controllers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ers.dao.UserDAO;
import com.ers.dao.UserDAOImpl;
import com.ers.models.User;

@RestController
public class UserController {

	private UserDAO dao = new UserDAOImpl();

	@RequestMapping(value = "/user/{id}", produces= "application/json")
	public User getSingleUser(@PathVariable("id") int id) {
		User ur = new User();
		System.out.println(id);
		ur = dao.getUserById(id);
		System.out.println(ur);
		return ur; 
	}

	@RequestMapping(value = "/users", produces= "application/json")
	public List<User> getAllUsers() {
		ArrayList<User> urs = dao.getAllUsers();
		System.out.println(urs);
		return urs;
	}

}
