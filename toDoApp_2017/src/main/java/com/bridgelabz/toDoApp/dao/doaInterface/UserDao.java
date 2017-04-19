package com.bridgelabz.toDoApp.dao.doaInterface;

import com.bridgelabz.toDoApp.model.User;

public interface UserDao {

	public boolean signUp(User user);

	public User authUser(String email, String password);

}
