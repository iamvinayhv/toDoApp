package com.bridgelabz.toDoApp.dao.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.bridgelabz.toDoApp.dao.doaInterface.ToDoDao;
import com.bridgelabz.toDoApp.model.ToDo;

public class ToDoDaoImpl implements ToDoDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session session = null;
	
	@Override
	public boolean addNote(ToDo toDo) {
		
		try {
			session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			
			session.save(toDo);
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
	public List<ToDo> getNotes(int id) {
		
		try {
			session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			
			String hql = "from ToDo where user_id=:userId";
			Query query = session.createQuery(hql);
			query.setParameter("userId", id);
			List<ToDo> notes = query.list();
			transaction.commit();
			return notes;
		}
		finally {
			if(session != null)
			session.close();
		}
	}



	@Override
	public int deleteNote(int id) {
		
		try {
			session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			
			String hql = "delete from ToDo where id=:id";
			Query query = session.createQuery(hql);
			query.setParameter("id", id);
			int result = query.executeUpdate();
			transaction.commit();
			return result;
		}
		finally {
			if(session != null) {
				session.close();
			}
		}
	}



	@Override
	public boolean updateNote(ToDo toDo) {
		
		try {
			session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			session.update(toDo);
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

}
