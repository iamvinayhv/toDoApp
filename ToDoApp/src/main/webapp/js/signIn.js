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


function signIn() {
	  var email = document.getElementById("form_email").value;
	  var password = document.getElementById("form_password").value;

	 
	  console.log(email);
	  console.log(password);
	  console.log("hai");
	  
	  var login = {email:email , password:password};

	  $.ajax({
			
			type: "POST",
			url: "signIn",
			data:login,
			dataType:'json',
			success : function(data,status,ff) {
				console.log("okkkkkkkkk");
				console.log("data "+data);
				console.log("status "+status);
				console.log("oth "+ff);
				
				window.location = "toDoHome.jsp";
			},
			error : function(data,status,ff) {
				console.log("errrrrrrrrrrrro");
				console.log("data "+data);
				console.log("status "+status);
				console.log("oth "+ff);
				window.location = "signUp.jsp";
				
			}
			
		});
	  
	}


