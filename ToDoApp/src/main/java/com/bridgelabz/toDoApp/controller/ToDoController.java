package com.bridgelabz.toDoApp.controller;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bridgelabz.toDoApp.model.ToDo;
import com.bridgelabz.toDoApp.model.User;
import com.bridgelabz.toDoApp.service.serviceInterface.ToDoService;

@Controller
public class ToDoController {

	@Autowired
	private ToDoService toDoService;
	
	
	
	@RequestMapping(value="/toDoHome")
	public ModelAndView toDoHome(HttpServletRequest request,HttpServletResponse response) {
		
		HttpSession session = request.getSession(false);
		User user = (User) session.getAttribute("user");
		
		if( user != null) {
			
			System.out.println(session);
			System.out.println(user);
			
			
			List<ToDo> todoList = getNotes(user.getId());
			
			
			if( todoList != null ) {
				Collections.reverse(todoList);
				
				ModelAndView model = new ModelAndView("toDoHome");
				model.addObject("todoList", todoList);
				model.addObject("user", user);
				return model;
			}
			else {
				return new ModelAndView("toDoHome");
			}
		}
		else {
			return new ModelAndView("redirect:/signInPage");
		}
	}
	
	
	
	
	@RequestMapping(value="/addNewNote")
	public ModelAndView addNotePage(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession(false);
		User user = (User) session.getAttribute("user");
		
		if(user != null ) {
			return new ModelAndView("addNote");
		}
		else {
			return new ModelAndView("redirect:/signInPage");
		}
	}
	
	
	@RequestMapping(value="/addNote",method=RequestMethod.POST)
	public ModelAndView addNote(ToDo toDo, HttpServletRequest request, HttpServletResponse response) {
	
		HttpSession session = request.getSession(false);
		User user = (User) session.getAttribute("user");
		
		if( user != null) {
			
			toDo.setUser(user);
			
			toDoService.addNote(toDo);
			
			return new ModelAndView("redirect:/toDoHome");
		}
		else {
			return new ModelAndView("redirect:/signInPage");
		}
		
		
	}
	
	
	
	public List<ToDo> getNotes(int userId) 
	{
		List<ToDo> todoList = toDoService.getNotes(userId);
		if( !todoList.isEmpty()) {
			
			return todoList;
		}
		else {
			return null;
		}
	}
	
	
	
	
	@RequestMapping(value="deleteNote")
	public ModelAndView deleteNote(@RequestParam("id") int id, HttpServletRequest request, HttpServletResponse response) {
	
		HttpSession session = request.getSession(false);
		User user = (User) session.getAttribute("user");
		
		if( user != null ) {
			toDoService.deleteNote(id);
			return new ModelAndView("redirect:/toDoHome");
		}
		else {
			return new ModelAndView("redirect:/signInPage");
		}
		
	}
	
	
	
	
	static int todoId=0;
	@RequestMapping(value="update")
	public ModelAndView update(@RequestParam("id")int id, HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession(false);
		User user = (User) session.getAttribute("user");
		
		if(user != null) {
			todoId=id;
			return new ModelAndView("update");
		}
		else {
			return new ModelAndView("redirect:/signInPage");
		}
	}
	
	
	
	@RequestMapping(value="updateNote")
	public ModelAndView updateNote(ToDo toDo , HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession(false);
		toDo.setId(todoId);
		User user = (User) session.getAttribute("user");
		
		if(session != null && user != null) {
			
			toDo.setUser(user);
			toDoService.updateNote(toDo);
			return new ModelAndView("redirect:/toDoHome");
		}
		else {
			return new ModelAndView("redirect:/signInPage");
		}
	}
}
