package com.ers.dao;

import java.math.BigDecimal;
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
		String sql = "SELECT * FROM users WHERE user_id=" + id;
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

}
