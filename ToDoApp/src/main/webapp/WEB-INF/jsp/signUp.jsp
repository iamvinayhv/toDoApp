<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>

	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
	


<script src="js/signUp.js" type="text/javascript"></script>



<title>signUp to ToDo</title>

<style> 
input[type=text] {
    width: 100%;
    padding: 6px 20px;
    margin: 8px 0;
    box-sizing: border-box;
    border: 2px solid black;
    border-radius: 5px;
}
input[type=password] {

	width: 100%;
    padding: 6px 20px;
    margin: 8px 0;
    box-sizing: border-box;
    border: 2px solid black;
    border-radius: 5px;
}

.bg
{
	width: 350px;
	hight: 200px;
	background-color: rgba(0,0,0,0.4);
	margin:0 auto;
	margin-top: 10px;
	padding-top:10px;
	padding-left:10px;
	border-radius: 5px;
}


.bar
{
	width: 350px;
	background-color: rgba(0,0,0,0.4);
	margin-top: 1px;
	padding-top:5px;
	padding-left:10px;
	border-radius: 5px;
}



</style>


</head>



<body>
<center>

<div class=bar>
<h3 style="color:white">SignUp to ToDoApp</h3>
</div>



<form action="signUp" method="post" id="signUpPage">
<div class=bg >
<table style="color:white">

<tr><td>First Name	</td><td>	<input type="text" name="firstName" placeholder="first name" id="form_firstName"></td></tr>		<tr style="color:red;"><td colspan="2"><span class="error_form" id="firstName_error_msg"></span></td></tr>
<tr><td>Last Name	</td><td>	<input type="text" name="lastName" placeholder="last name" id="form_lastName"></td></tr>		<tr style="color:red;"><td colspan="2"><span class="error_form" id="lastName_error_msg"></span></td></tr>
<tr><td>Mobile No.	</td><td>	<input type="text" name="mobile" placeholder="mobile number" id="form_mobile"></td></tr>		<tr style="color:red;"><td colspan="2"><span class="error_form" id="mobile_error_msg"></span></td></tr>
<tr><td>E-mail ID	</td><td>	<input type="text" name="email" placeholder="email Id" id="form_email"></td></tr>				<tr style="color:red;"><td colspan="2"><span class="error_form" id="email_error_msg"></span></td></tr>
<tr><td>Password	</td><td>	<input type="password" name="password" placeholder="password" id="form_password"></td></tr>		<tr style="color:red;"><td colspan="2"><span class="error_form" id="password_error_msg"></span></td></tr>

<tr><td></td><td><input type="submit" value="signUp" style="color:green" ></td></tr>
</table>

</div>
<br>
<a href="signInPage" style="color:black">Already Registered? SignIn</a>

</center>

</form>

</body>
</html>