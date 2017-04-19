package com.bridgelabz.toDoApp.vlidator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.bridgelabz.toDoApp.model.User;

public class UserValidation implements Validator{

	
	private Pattern pattern;
	private Matcher matcher;
	
	private static String EMAIL_PATTERN  = "^[A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
											+"[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private static String STRING_PATTERN = "[a-zA-Z]+";
	private static String MOBILE_PATTERN = "[0-9]{10}";
	private static String PASSWORD_PATTERN = "[A-Za-z0-9]{5,10}";
	
	@Override
	public boolean supports(Class<?> arg0) {
		
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		User user = (User) target;
		
	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "required.firstName", "First name is required your are leaving blank");
		
		if( user.getFirstName() != null && !user.getFirstName().isEmpty() ) {
			
			pattern = Pattern.compile(STRING_PATTERN);
			matcher = pattern.matcher(user.getFirstName());
			if( !matcher.matches() ) {
				errors.rejectValue("firstName", "firstName.required", "Enter correct First Name");
			}
		}
		
		
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "required.email", "Email is required");
		
		if( user.getEmail() != null && !user.getEmail().isEmpty() ) {
			
			pattern = Pattern.compile(EMAIL_PATTERN);
			matcher = pattern.matcher(user.getEmail());
			if( !matcher.matches() ) {
				errors.rejectValue("email", "email.required", "Enter correct email");
			}
		}
		
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mobile", "required.mobile", "Mobile number is required you are leaving blank");
		
		if( user.getMobile() != null && !user.getMobile().isEmpty() ) {
			
			pattern = Pattern.compile(MOBILE_PATTERN);
			matcher = pattern.matcher(user.getMobile());
			if( !matcher.matches() ) {
				errors.rejectValue("mobile", "mobile.required", "Enter correct mobile number");
			}
		}
		
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "required.password", "Password can not be empty");
		
		if( user.getPassword() != null && !user.getPassword().isEmpty()) {
			
			pattern = Pattern.compile(PASSWORD_PATTERN);
			matcher = pattern.matcher(user.getPassword());
			if( !matcher.matches() ) {
				errors.rejectValue("password", "password.required", "password length must be between 5 to 10");
			}
		}
		
	}
}
