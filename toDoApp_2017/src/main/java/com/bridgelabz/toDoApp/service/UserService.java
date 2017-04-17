package com.bridgelabz.toDoApp.service;

import com.bridgelabz.toDoApp.model.User;

public interface UserService {

	public boolean signUp(User user);

	public User logIn(String email, String password);

}
