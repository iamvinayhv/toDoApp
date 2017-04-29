<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>toDoHome</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>



<style>


body {
    font-family: "Lato", sans-serif;
}

.sidenav {
    height: 100%;
    width: 0;
    position: fixed;
    z-index: 1;
    top: 0;
    margin-top:68px;
    left: 0;
    background-color:white;
    overflow-x: hidden;
    transition: 0.5s;
    padding-top: 60px;
}

.sidenav a {
    padding: 8px 8px 8px 32px;
    text-decoration: none;
    font-size: 25px;
    color: #818181;
    display: block;
    transition: 0.3s;
}

.sidenav a:hover, .offcanvas a:focus{
    color: #f1f1f1;
}

.sidenav .closebtn {
    position: absolute;
    top: 0;
    right: 25px;
    font-size: 36px;
    margin-left: 50px;
}

@media screen and (max-height: 450px) {
  .sidenav {padding-top: 15px;}
  .sidenav a {font-size: 18px;}
}




input[type=text] {
    width: 57%;
    height:50px;
    padding-top:15px;
    margin: 8px 0;
    box-sizing: border-box;
    border: 2px solid white;
    border-radius: 3px;
    padding-bottom: 15px;
}

.bar
{
	/* width: 1500px; */
	height:60px;
	background-color: #f5b400;
	padding-top:0px;
	padding-bottom:7px;
	border-radius: 3px;
}



.search
{
	width: 700px;
	hight: 100px;
	background-color: #f5b400;
	margin:0 auto;
	padding-top:2px;
	padding-right:10px;
	border-radius: 5px;
	padding-bottom: 5px;
	
}

.name
{
	padding-left:10px;
	
}


.entry
{
	width: 350px;
	min-height:40px;
	background-color: white;
	margin:0px  auto;
	margin-top: 10px;
	padding-top:10px;
	border-radius: 3px;
	
}


.note
{
	width: 250px;
	min-height:100px;
	background-color: white;
	margin:0px  auto;
	margin-top: 20px;
	padding-top:10px;
	margin-left:50px;
	display: inline-block;
	border-radius: 0px;
	
	
	
	position: inherit;
    cursor: pointer;
    -webkit-user-select: none;
    -moz-user-select: none;
    -ms-user-select: none;
    user-select: none;

}



</style>



<script>


function openNav() {
    document.getElementById("mySidenav").style.width = "250px";
}

function closeNav() {
    document.getElementById("mySidenav").style.width = "0";
}


function openEntry() {
	document.getElementById("newNote").style.display="block";
}


function refersh() {
	document.getElementById()
}

function searchcolor() {
	document.getElementById("sea").style.backgroundColor="white";
}


</script>




</head>














<body bgcolor="silver">

<div class="bar" style="margin-left: -10px;margin-top: -8px;margin-right: -10px;">
	<div class="name" style="margin-left:10px;">
	
		<span style="font-size:25px;cursor:pointer;margin-right:35px;" onclick="openNav()" ondblclick="closeNav();">&#9776;</span>
		<week style="font-size:23px;">Google Keep </week>
		<input style="margin-left:25px; background-color: #f5b400;" type="text" placeholder="	Search" onclick="searchcolor()" id="sea">
		<a onclick="refersh()" style="font-size:25px; margin-left:30px; text-decoration: none;" href="toDoHome">&#8635;</a>
		<span style="margin-left:20px;">${user.firstName} ${ user.lastName} </span>
	
	</div>
</div>



<div id="mySidenav" class="sidenav">

  <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
  
  <strong style="margin-left:20px;">${user.email}</strong><br><br>
  <a href="#">Notes</a>
  <a href="#">Remainders</a>
  <a href="#">Settings</a>
  <a href="<c:url value='signOut'/>">SignOut</a>
  
</div>





<div id="take" class="entry" onclick="openEntry();">
	<span style="cursor:pointer; margin-left: 20px;">Take a note...</span>

		<div id="newNote" class="note"  style="display: none; ">
		
				<form action="addNote" method="post">
				
					<input style="margin-left:10px;width: 225px; " type="text" name="title" placeholder="title">
					<input style="margin-left:10px;width: 225px; " type="text" name="note" placeholder="note">
					
					<input style="margin-left:40px;color:green" type="submit" value="add Note">
				
				</form>
		</div>
</div>

<br><br>



<c:forEach var="temp" items="${todoList}">

	<div class="note" onclick="popUp()" >
	
		<span style="margin-left:30px;">${temp.title} </span><br><br>
		<span style="margin-left:30px;">${temp.note} </span><br><br>
		<span style="margin-left:30px;">${temp.remainder}</span>
		
		<br>
		<a href="<c:url value='deleteNote?id=${temp.id}'/>" style="margin-left:30px; font-size: 25px;text-decoration: none;">&#9986;</a>
		<a href="<c:url value='update?id=${temp.id}'/>" style="margin-left:140px;font-size: 25px;text-decoration: none;">&#9997;</a>
	
	
	</div>

</c:forEach>

</body>
</html>