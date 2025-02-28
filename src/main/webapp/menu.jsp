<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メニュー画面</title>
</head>
<body>

<h1>メニュー画面</h1>
<hr>
	<%-- form 登録 --%>
	<form action="task-add-transition-ago-servlet" method="POST">
		<input type="submit" value="タスク登録">
	</form>
	
	<%-- form 一覧表示 --%>
	<form action="TaskListServlet" method="POST">
		<input type="submit" value="タスク一覧">
	</form><br>

	<%-- form ログアウト --%>
	<form action="LogoutServlet" method="GET">
		<input type="submit" value="ログアウト">
	</form>
	
<%-- テスト用 編集/削除 --%>
<hr>
編集/削除テスト用
<form action="judge-user-edit-servlet" method="POST">
	<input type="submit" value="タスク編集">
</form>
<%--テストのため一時的に method = "GET" by富--%>
<form action="JudgeUserDeleteServlet" method="GET">
	<input type="submit" value="タスク削除">
</form>


</body>
</html>