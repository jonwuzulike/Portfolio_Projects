package com.ers.dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.ers.models.User;
import com.ers.util.HibernateUtil;

public class UserDAOImpl implements UserDAO {

	public User getUserById(int id) {
		System.out.println("In UserDao -- Retrieveing user by id.");
		User user = null;
		Session session = HibernateUtil.getSession();
		user = session.get(User.class, id);
		if (user != null) {
			System.out.println("Successful retrival" + user.toString());
		}
		return user;
	}

	public ArrayList<User> getAllUsers() {
		System.out.println("In UserDao -- Retrieveing all users.");
		ArrayList<User> allUsers = new ArrayList<User>();
		Session session = HibernateUtil.getSession();

		String hql = "FROM com.ers.models.User";
		Query q = session.createQuery(hql);
		List users = q.list();
		for (Object user : users) {
			user = (User) user;
			System.out.println(user);
			allUsers.add((User) user);
		}

		session.close();
		System.out.println(allUsers);
		return allUsers;
	}

	public User userLogin(String email, String password) {
		Session sessiion = HibernateUtil.getSession();
		User user = null;
		String hql = "FROM com.ers.models.User WHERE email = :email AND password = :password ";
		Query q = sessiion.createQuery(hql);
		q.setParameter("email", email);
		q.setParameter("password", password);
		List users = q.list();
		for (Object o : users) {
			user = (User) o;
			System.out.println(user);
		}

		return user;
	}

}
