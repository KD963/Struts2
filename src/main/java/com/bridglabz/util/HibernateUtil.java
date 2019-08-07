package com.bridglabz.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtil {

	private static SessionFactory sessionFactory;

	public static SessionFactory getSession() {
		if (sessionFactory == null) {
			sessionFactory = new AnnotationConfiguration().configure("hibernate.cfg.xml").buildSessionFactory();
		}
		return sessionFactory;
	}

}
