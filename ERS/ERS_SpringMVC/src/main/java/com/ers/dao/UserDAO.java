package com.ers.dao;

import java.math.BigDecimal;
import java.util.ArrayList;

import com.ers.models.User;

public interface UserDAO {
	
	public User getUserById(int id);
	
	public ArrayList<User> getAllUsers();	

}
