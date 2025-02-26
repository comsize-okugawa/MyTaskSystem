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
	<%--　エラー時メッセージ出力 --%>
		<% String message = (String)request.getAttribute("message"); 
			if(message != null){
		%>
		
		<%= message %>
		
		<% }
		%>
		<%= message %>
		
		<h3>ユーザIDとパスワードを入力してください</h3>
		<%-- 入力欄 --%>
		<form action="LoginServlet" method="POST">

			<table>

<<<<<<< HEAD
				<tr>
					<th>ユーザID</th>
					<td><input type="text" name=userId></td>
				</tr>
				<tr>
					<th>パスワード</th>
					<td><input type="text" name=password></td>
				</tr>
=======
	<form action="LoginServlet" method="POST">

		<table>

			<tr>
				<th>ユーザID</th>
				<td><input type="text" name=userId></td>
			</tr>
			<tr>
				<th>パスワード</th>
				<td><input type="text" name=password></td>
			</tr>
			<tr>
				<td><input type="submit" value="ログイン"></td>
				<td><input type="reset" value="リセット"></td>
			<tr>
		</table>
	</form>
>>>>>>> 54bf2d953f787c830466c0b15d6ca687ba5b766b

				<tr>
					<td><input type="submit" value="ログイン"></td>
					<td><input type="reset" value="リセット"></td>
				<tr>
			</table>
		</form>
		
</body>
</html>