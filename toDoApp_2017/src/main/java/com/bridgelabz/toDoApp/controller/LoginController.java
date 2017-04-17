package com.bridgelabz.toDoApp.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.toDoApp.model.User;
import com.bridgelabz.toDoApp.service.UserService;

@RestController
public class LoginController {

	@Autowired
	private UserService userService;
	

	@RequestMapping(value="/signIn", method=RequestMethod.POST)
	public ResponseEntity<String> logIn(@RequestBody Map<String,String> loginMap, BindingResult bindingResult, HttpServletRequest request, HttpServletResponse response) {
		
		
		User user = userService.logIn(loginMap.get("email"),loginMap.get("password"));
		
		if(user != null) {
			return new ResponseEntity<String>("{status:'success', message:'login completed'}",HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String>("{status:'failure', message:'login failed'}",HttpStatus.NOT_FOUND);
		}
	}
}
