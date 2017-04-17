package com.bridgelabz.toDoApp.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.bridgelabz.toDoApp.dao.UserDao;
import com.bridgelabz.toDoApp.model.User;

public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	
	@Override
	public boolean signUp(User user) {
		
		return userDao.signUp(user);
	}

	@Override
	public User logIn(String email, String password) {
		
		return userDao.logIn(email,password);
	}
}
