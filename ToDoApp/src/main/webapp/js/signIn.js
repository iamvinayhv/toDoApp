$(function(){
	
	$("#email_error_msg").hide();
	$("#password_error_msg").hide();
	
	
	var error_email = false;
	
	$("#form_email").focusout(function() {
		
		check_email();
		
	});

function check_email() {
	
	var email_pattern = new RegExp(/^[+a-zA-Z0-9._-]+@[+a-zA-Z0-9._-]+\.[a-zA-Z]{2,4}$/i);
	if(email_pattern.test($("#form_email").val())) {
		
		$("#email_error_msg").hide();
	}
	else {
		$("#email_error_msg").html("enter valid email");
		$("#email_error_msg").show();
		error_email = true;
	}
}


});
