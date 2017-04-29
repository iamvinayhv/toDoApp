package com.bridgelabz.toDoApp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bridgelabz.toDoApp.model.User;
import com.bridgelabz.toDoApp.service.serviceInterface.UserService;
import com.bridgelabz.toDoApp.vlidator.UserValidation;


@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserValidation userValidation;
	
	@RequestMapping(value="/signUp", method=RequestMethod.POST)
	public ModelAndView signUp(User user, BindingResult bindingResult, HttpServletRequest request, HttpServletResponse response) {
		
		userValidation.validate(user, bindingResult);
		
		if( bindingResult.hasErrors() ) {
				String msg = "errors in required fields";
				return new ModelAndView("signUp","msg",msg);
		}
		else {
			
			boolean result = userService.signUp(user);
			
			if(result) {
				return new ModelAndView("redirect:/signInPage");
			}
			else {
				String msg = "This mail Id already registerd...SignIn...";
				return new ModelAndView("signIn","msg", msg );
			}
		}
	}
	
	@RequestMapping(value="signUpPage") 
	public ModelAndView signUpPage() {
		
		return new ModelAndView("signUp");
	}
	
	
}
