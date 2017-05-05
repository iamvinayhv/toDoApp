<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="updateNote" method="post">

<table style="color:blue">


<tr><td>Title	</td><td><input  type="text" name="title" placeholder="title"></td></tr>
<tr><td>Note	</td><td><input type="text" name="note" placeholder="note"></td></tr>
<tr><td>Remainder	</td><td><input type="text" name="remainder" placeholder="yyyy-mon-dd hr:min:ss"></td></tr>

</table>



<input type="submit" value="update Note" style="color:green">

</form>


</body>
</html>