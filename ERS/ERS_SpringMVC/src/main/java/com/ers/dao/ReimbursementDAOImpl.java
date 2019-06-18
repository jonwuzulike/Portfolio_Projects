package com.ers.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.ers.models.Reimbursement;
import com.ers.util.HibernateUtil;

@Repository
public class ReimbursementDAOImpl implements ReimbursementDAO {

	public ArrayList<Reimbursement> getAll() {
		System.out.println("In ReimbursementDAOImpl ---- getAll");
		ArrayList<Reimbursement> list = new ArrayList<Reimbursement>();
		Session session = HibernateUtil.getSession();
		String hql = "FROM com.ers.models.Reimbursement";
		Query q = session.createQuery(hql);
		List<Object[]> users = q.list();
		for (Object o : users) {
			o = (Reimbursement) o;
			list.add((Reimbursement) o);
			System.out.println(o);
		}
		session.close();
		return list;
	}

	public ArrayList<Reimbursement> getByUser(int id) {
		System.out.println("In ReimbursementDAOImpl ---- getByUserId");
		ArrayList<Reimbursement> list = new ArrayList<Reimbursement>();
		Session session = HibernateUtil.getSession();
		String hql = "FROM com.ers.models.Reimbursement WHERE userId = :userId";
		Query q = session.createQuery(hql);
		q.setParameter("userId", id);
		List users = q.list();
		for (Object o : users) {
			o = (Reimbursement) o;
			System.out.println(o);
			list.add((Reimbursement) o);
		}
		session.close();
		return list;
	}

}
