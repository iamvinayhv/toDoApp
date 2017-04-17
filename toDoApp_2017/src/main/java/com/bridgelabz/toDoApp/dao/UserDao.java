package com.bridgelabz.toDoApp.dao;

import com.bridgelabz.toDoApp.model.User;

public interface UserDao {

	public boolean signUp(User user);

	public User logIn(String email, String password);

}
