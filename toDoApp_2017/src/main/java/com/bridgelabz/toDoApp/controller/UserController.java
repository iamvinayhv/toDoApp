package com.bridgelabz.toDoApp.controller;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.toDoApp.model.User;
import com.bridgelabz.toDoApp.service.serviceInterface.UserService;
import com.bridgelabz.toDoApp.vlidator.UserValidation;


@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserValidation userValidation;
	
	@RequestMapping(value="/signUp", method=RequestMethod.POST)
	public ResponseEntity<String> signUp(@RequestBody User user,BindingResult bindingResult, HttpServletRequest request, HttpServletResponse response) {
		
		userValidation.validate(user, bindingResult);
		
		if( bindingResult.hasErrors() ) {
			
			List<ObjectError> errors = bindingResult.getAllErrors();
			Iterator<ObjectError> i = errors.iterator();
			while (i.hasNext()) {
				System.out.println(i.next());
			}
			
			return new ResponseEntity<String>("errors in required fields",HttpStatus.NOT_ACCEPTABLE);
		}
		else {
			
			boolean result = userService.signUp(user);
			
			if(result) {
				return new ResponseEntity<String>("{status:'success', message:'Data saved'}",HttpStatus.OK);
			}
			else {
				return new ResponseEntity<String>("{status:'failure', message:'Data not saved'}",HttpStatus.NOT_ACCEPTABLE);
			}
		}
	}
}
