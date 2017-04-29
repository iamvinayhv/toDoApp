package com.bridgelabz.toDoApp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.bridgelabz.toDoApp.model.User;
import com.bridgelabz.toDoApp.service.serviceInterface.UserService;

@RestController
public class LoginController {

	@Autowired
	private UserService userService;

	@RequestMapping(value="/")
	public ModelAndView signInPage0(HttpServletRequest request, HttpServletResponse response) {
		
		return new ModelAndView("redirect:/signInPage");
		
	}
	
	
	@RequestMapping(value="/signInPage")
	public ModelAndView signInPage(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if( user == null) {
			return new ModelAndView("signIn");
		}
		else {
			return new ModelAndView("redirect:/toDoHome");
		}
	}
	
	
	@RequestMapping(value="/signIn", method=RequestMethod.POST)
	public ModelAndView logIn(@RequestParam("email")String email, @RequestParam("password")String password, HttpServletRequest request, HttpServletResponse response) {
		
		
		User user = userService.authUser(email, password);
		
		if(user != null) {
			HttpSession session = request.getSession(true);
			session.setAttribute("user", user);
			
			return new ModelAndView("redirect:/toDoHome");
		}
		else 
		{
			String msg = "Invalid user id or password";
			return new ModelAndView("signIn", "msg", msg);
		}
	}
}
