package com.bridgelabz.toDoApp.dao.doaInterface;

import java.util.List;

import com.bridgelabz.toDoApp.model.ToDo;
import com.bridgelabz.toDoApp.model.User;

public interface ToDoDao {

	public void addNote(ToDo toDo);

	public List<ToDo> getNotes(int id);

	public void deleteNote(int id);

	public boolean updateNote(ToDo toDo);

}
