package com.bridgelabz.toDoApp.dao.doaInterface;

import java.util.List;

import com.bridgelabz.toDoApp.model.ToDo;
import com.bridgelabz.toDoApp.model.User;

public interface ToDoDao {

	public boolean addNote(ToDo toDo);

	public List<ToDo> getNotes(int id);

	public int deleteNote(int id);

	public boolean updateNote(ToDo toDo);

}
