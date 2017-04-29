package com.bridgelabz.toDoApp.service.serviceInterface;

import java.util.List;

import com.bridgelabz.toDoApp.model.ToDo;

public interface ToDoService {

	public void addNote(ToDo toDo);

	public List<ToDo> getNotes(int id);

	public void deleteNote(int id);

	public boolean updateNote(ToDo toDo);

}
