package com.bridgelabz.toDoApp.controller;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.bridgelabz.toDoApp.model.ToDo;
import com.bridgelabz.toDoApp.model.User;
import com.bridgelabz.toDoApp.service.serviceInterface.ToDoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.util.JSONPObject;

@RestController
public class ToDoController {

	@Autowired
	private ToDoService toDoService;
	
	
	
	@RequestMapping(value="/toDoHome")
	public ModelAndView toDoHome(HttpServletRequest request,HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		
		if( user != null) {
			
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
	
	
	
	@RequestMapping(value="/addNote",method=RequestMethod.POST,produces="application/json")
	public ResponseEntity<String> addNote(ToDo toDo, HttpServletRequest request, HttpServletResponse response) throws JsonProcessingException {
	
		System.out.println("kunfu");
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		
		if( user != null ) {
			
			if(toDo.getNote() != "" || toDo.getTitle() != "") {
				
				toDo.setUser(user);
				toDoService.addNote(toDo);
				System.out.println("kkkkk");
				
				
				ObjectMapper mapper = new ObjectMapper();
				ObjectNode root = mapper.createObjectNode();
				
				//ObjectNode todo = mapper.createObjectNode();
				//todo.put("id", toDo.getId());
				
				root.put("status", "success");
				
				toDo.setUser(null);
				
				root.putPOJO("todo", toDo); 
				
				// set("todo", todo);
				String lstr = mapper.writeValueAsString(root);
				System.out.println( lstr ); 
				return new ResponseEntity<String>(lstr, HttpStatus.OK);
			}
			else {
				System.out.println("gggggggg");
				return new ResponseEntity<String>("{status:'failure'}", HttpStatus.NOT_ACCEPTABLE);
			}
			
			
			
		}
		else {
			return new ResponseEntity<String>("{status:'failure'}", HttpStatus.NOT_ACCEPTABLE);
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
	
		HttpSession session = request.getSession();
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
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		
		if(user != null) {
			todoId=id;
			return new ModelAndView("update");
		}
		else {
			return new ModelAndView("redirect:/signInPage");
		}
	}
	
	
	
	@RequestMapping(value="updateNote", method=RequestMethod.POST)
	public ModelAndView updateNote(ToDo toDo , HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		
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
