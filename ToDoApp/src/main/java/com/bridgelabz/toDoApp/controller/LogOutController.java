package com.bridgelabz.toDoApp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * this class is used to logOut the user handles the "/signOut" request"
 * @author bridgeit vinay
 *
 */
@RestController
public class LogOutController {
	
	/**
	 * @param request
	 * @param response
	 * @return String message and Status
	 */
	@RequestMapping(value="/signOut")
	public ModelAndView logOut(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession(false);
		
		if(session.getAttribute("user") != null) {
			session.removeAttribute("user");
			session.invalidate();
			request.getSession(true);
			return new ModelAndView("redirect:/signInPage");
		}
		else {
			return new ModelAndView("redirect:/signUp");
		}
	}

}
