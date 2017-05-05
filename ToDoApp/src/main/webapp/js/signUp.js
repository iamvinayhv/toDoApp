$(function(){
	
	$("#firstName_error_msg").hide();
	$("#mobile_error_msg").hide();
	$("#email_error_msg").hide();
	$("#password_error_msg").hide();
	
	var error_firstName = false;
	var error_mobile = false;
	var error_email = false;
	var error_password = false;
	
	
	$("#form_firstName").focusout(function() {
		
		
		check_firstName();
		
	});
	
			
	$("#form_mobile").focusout(function() {
			
			check_mobile();
			
		});
	
	
	$("#form_email").focusout(function() {
		
		check_email();
		
	});
	
	
	$("#form_password").focusout(function() {
		
		check_password();
		
	});
	
	
	
	
	function check_firstName() {
		
		var name_ptrn = new RegExp(/^[a-zA-Z\w]{5,13}$/);
		var firstName_length = $("#form_firstName").val().length;
		
		if( !name_ptrn.test($("#form_firstName").val()) ) {
			
			$("#firstName_error_msg").html("should be between 5-13 characters and space not required");
			$("#firstName_error_msg").show();
			error_firstName = true;
		}
		else {
			$("#firstName_error_msg").hide();
		}
	}
	
	
	function check_mobile() {
		
		var mobile_pattern = new RegExp(/^[0]?[789]\d{9}$/);
		if(mobile_pattern.test($("#form_mobile").val())) {
			
			$("#mobile_error_msg").hide();
		}
		else {
			$("#mobile_error_msg").html("mobile number must be 10 digits");
			$("#mobile_error_msg").show();
			error_mobile = true;
		}
	}
	
	
	function check_email() {
		
		var email_pattern = new RegExp(/^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/);
		if(email_pattern.test($("#form_email").val())) {
			
			$("#email_error_msg").hide();
		}
		else {
			$("#email_error_msg").html("enter valid email");
			$("#email_error_msg").show();
			error_email = true;
		}
	}
	
	
	

	function check_password() {
		
		var password_length = $("#form_password").val().length;
		
		if(password_length >=7  ) {
			
			$("#password_error_msg").hide();
		}
		else {
			$("#password_error_msg").html("password must be 7 charactors");
			$("#password_error_msg").show();
			error_password = true;
			
		}
		
	}
	
	

});