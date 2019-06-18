package com.ers.dao;

import java.util.ArrayList;

import com.ers.models.User;

public interface UserDAO {
	
	//Gets a user by id.
	public User getUserById(int id);
	
	//Return all users in the DB.
	public ArrayList<User> getAllUsers();	
	
	// Allows a user to login.
	public User userLogin(String email, String password);
	
	

}
