package com.ers.controllers;


import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ers.dao.UserDAO;
import com.ers.dao.UserDAOImpl;
import com.ers.models.User;

@RestController
public class UserController {

	private UserDAO dao = new UserDAOImpl();
	
	@RequestMapping(value = "/test", produces= "application/json") 
	public String test() {
		return "Testing";
	}
	
	@RequestMapping(value = "/login", produces= "application/json")
	public User login( @RequestParam String email, @RequestParam String password) {
		User ur = new User();
		System.out.println(email + " " + password);
		if (email != null && password != null) {
			ur = dao.userLogin(email, password);
		}
		return ur;
	}

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
