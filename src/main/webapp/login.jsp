<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
</head>
<body>

	<h1>ログイン画面</h1>
	<hr>
	<%--　エラーメッセージ出力 --%>
		<% String message = (String)request.getAttribute("message"); 
			if(message != null){
		%>
		
		<%= message %>
		
		<% }
		%>
		
		<h3>ユーザIDとパスワードを入力してください</h3>
		<%-- 入力欄 --%>
		<form action="LoginServlet" method="POST">

			<table>


				<tr>
					<th>ユーザID</th>
					<td><input type="text" name= "userId" ></td>
				</tr>
				<tr>
					<th>パスワード</th>
					<td><input type="text" name= "password" ></td>
				</tr>


				<tr>
					<td><input type="submit" value="ログイン"></td>
					<td><input type="reset" value="リセット"></td>
				<tr>
			</table>
		</form>
		
</body>
</html>