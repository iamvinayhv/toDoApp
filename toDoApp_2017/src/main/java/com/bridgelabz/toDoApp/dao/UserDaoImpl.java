package com.bridgelabz.toDoApp.dao;


import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.bridgelabz.toDoApp.model.User;

public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session session = null;
	
	@Override
	public boolean signUp(User user) {
		
		try {
			session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			
			session.save(user);
			transaction.commit();
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		finally {
			if(session != null) {
				session.close();
			}
		}
	}

	
	
	@Override
	public User logIn(String email, String password) {
		
		try {
			session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			
			Criteria criteria = session.createCriteria(User.class);
			User user = (User) criteria.add(Restrictions.conjunction().add(Restrictions.eq("email", email)).add(Restrictions.eq("password", password))).uniqueResult();
			transaction.commit();
			return user;
		}
		finally {
			if( session != null) {
				session.close();
			}
		}
	}
}
