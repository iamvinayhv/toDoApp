package com.bridgelabz.toDoApp.service.serviceInterface;

import com.bridgelabz.toDoApp.model.User;

public interface UserService {

	public boolean signUp(User user);

	public User authUser(String email, String password);

}
