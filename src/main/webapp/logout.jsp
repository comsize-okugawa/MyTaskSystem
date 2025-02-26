<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログアウト画面</title>
</head>
<body>
<h1>ログアウト画面</h1>

<% String message = (String)request.getAttribute("message"); 
	if(message != null){
%>

<%= message
%>

<% 
	} else {
%>
	ログアウト済です
	
<% }
%>


<form action = "login.jsp" method = "POST">
<input type = "submit" value = "ログイン画面へ">
</form>

</body>
</html>