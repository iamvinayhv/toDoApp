package com.bridgelabz.toDoApp.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.bridgelabz.toDoApp.dao.doaInterface.UserDao;
import com.bridgelabz.toDoApp.model.User;
import com.bridgelabz.toDoApp.service.serviceInterface.UserService;

public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	
	@Override
	public boolean signUp(User user) {
		
		return userDao.signUp(user);
	}

	@Override
	public User authUser(String email, String password) {
		
		return userDao.authUser(email,password);
	}
}
