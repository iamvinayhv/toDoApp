<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>toDoHome</title>


<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<script src="https://unpkg.com/packery@2/dist/packery.pkgd.min.js"></script>

<script src="js/toDoHome.js" type="text/javascript"></script>

<link rel="stylesheet" href="css/toDoHome.css">

</head>



<body bgcolor="white" id="body">


	<div class="container-fluid"  id="container">



		<div class="main row" id="main" style="position: absolute; padding-bottom: 50px;">

						<div class="bar" style="margin-left: -15px; margin-top: 0px; margin-right: -10px;">
							<div class="name" style="margin-left: 10px;">

								<span style="font-size: 25px; cursor: pointer; margin-right: 35px;" onclick="openNav()">&#9776;</span>
								<strong style="font-size:22px;">Vinay Keep</strong>
			
								<input style="margin-left: 25px; background-color: #f5b400;" type="text" placeholder="	Search" id="sea">
			
								<a style="font-size: 25px; margin-left: 30px; text-decoration: none;"href="toDoHome"><span class="glyphicon glyphicon-repeat"></span></a>
			
								<span class="buttons">
									<b class="glyphicon glyphicon-th grid"  style="margin-left: 20px; font-size: 23px;"></b>
									<b class="glyphicon glyphicon-list list" style="margin-left: 20px; font-size: 23px;"></b>
								</span>
								<strong style="margin-left: 20px;">${user.firstName} ${user.lastName}</strong><br> <br>
							</div>
						</div>

						<div id="mySidenav" class="sidenav" style="color: black;">
			
							<a  href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
			
							<strong style="margin-left: 20px;">${user.email}</strong><br> <br>
							<a href="#">Notes</a> <a href="#">Remainders</a> <a href="#">Settings</a>
							<a href="<c:url value='signOut'/>">SignOut</a>
							
						</div>

<div id="full">
		<div id="nav">
		
					<div id="take" class="entry">
						<b id="i">Take a note...</b>
					</div>
					
					<div id="newNote" class="Newnote" style="display: none;"  onmouseover="takeDesign()" onmouseout="takeDesignOut()">
		<!-- action="addNote" method="post" onclick="addNote(); return true;"-->
							<form action="addNote" method="post" onsubmit="return false;">
		
								<b style="font-size: 20px;"><input id="Title" style="margin-left: 15px;padding-left:20px; width: 570px;" type="text" name="title" placeholder="title..."></b>
								<b><input id="Note" style="margin-left: 15px; width: 570px;padding-left:20px;" type="text" name="note" placeholder="note..."></b>
								<input  id="done" style="margin-left: 530px; margin-bottom:10px;" type="submit" value="DONE">
		
							</form>
					</div>
		
					
<br> <br>
		
			<div id="ll" style="width: 600px;margin-left: 315px;">
						
					<c:forEach var="temp" items="${todoList}">

						<div id="onNote"  >
							<i  onmouseover="design('${temp.id}')" onmouseout="designOut('${temp.id}')">
								
							<div id="${temp.id}">	
								<div  id="note"  onclick="popUp('${temp.title}','${temp.note}','${temp.remainder}')" style="word-wrap: break-word; padding-top: 10px;padding-left:15px;padding-right:15px; background-color: #eeeeec;">
									
									<b style="margin-left: 15px;">${temp.title} </b><br> <br>
									<span style="margin-left: 15px;">${temp.note} </span><br> <br>
									<span style="margin-left: 15px;">${temp.remainder}</span> <br>
									
								</div>
								
								
								<div class="option" id="show"  visibility:visible;" style="padding-bottom:5px;padding-top:5px; border-top: 2px dotted #AAA;">
									
									<a href="<c:url value='deleteNote?id=${temp.id}'/>" style="margin-left: 30px; font-size: 25px; text-decoration: none;"><b  style="color: black;" class="fa fa-trash"></b></a> 
									<span id="updateClk" onclick="upDate('${temp.title}','${temp.note}','${temp.remainder}','${temp.id}')" style="margin-left: 30px; font-size: 25px; text-decoration: none;"><b class="fa fa-edit"></b></span>
								
								</div>
							</div>
							</i>
						
					</div>	
					</c:forEach>
			</div>
			
		</div>
</div>		
		

	</div>
	
	
		<div class="Pupup" id="pop" style="visibility: hidden; word-wrap: break-word; margin-top: 270px;">

		</div>
		
		
		
		<div class="updt" id="updt" style="visibility: hidden; word-wrap: break-word; margin-top: 270px;">
			
		</div>
		
		
</div>


</body>
</html>