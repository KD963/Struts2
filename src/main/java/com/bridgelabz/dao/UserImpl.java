package com.bridgelabz.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.bridglabz.model.User;
import com.bridglabz.util.HibernateUtil;

public class UserImpl implements IUser {

	public SessionFactory sessionFactory;

	public void register(User user) {

		sessionFactory = HibernateUtil.getSession();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(user);
		transaction.commit();
		session.close();
		System.out.println("user registered");

	}

	public boolean login(User user) {

		sessionFactory = HibernateUtil.getSession();
		Session session = sessionFactory.openSession();

		// String email = user.getEmail();
		// String password = user.getPassword();
		String sql = " from User u where u.email=:email and u.password=:password";

		/*
		 * String sql = "select * from User where email='" + email + "' and password='"
		 * + password + "'"; s
		 */

		Query query = session.createQuery(sql);

		query.setParameter("email", user.getEmail());
		query.setParameter("password", user.getPassword());

		@SuppressWarnings("unused")
		User users = (User) query.uniqueResult();

		@SuppressWarnings("unchecked")
		List<User> list = query.list();
		if (list.size() > 0) {
			session.close();
			return true;

		} else {
			return false;
		}

	}

	public boolean forget(User user) {
		sessionFactory = HibernateUtil.getSession();
		Session session = sessionFactory.openSession();
		String sql = "from User u where u.email=:email";
		Query query = session.createQuery(sql);
		query.setParameter("email", user.getEmail());
		User users = (User) query.uniqueResult();
		if (users != null) {
			return true;
		} else {
			return false;
		}

	}

	@SuppressWarnings("unused")
	public boolean reset(User user) {
		sessionFactory = HibernateUtil.getSession();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		System.out.println("before sql");
		String sql = "from User u where u.email=:email";

		Query query = session.createQuery(sql);
		query.setParameter("email", user.getEmail());
		User user1 = (User) query.uniqueResult();
	
		user1.setPassword(user.getPassword());
		System.out.println("After set password");
		session.save(user1);
		transaction.commit();
		if (user1 != null) {
			session.save(user1);
			session.close();
			return true;
		} else {
			return false;
		}

	}

}
