<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タスク編集成功画面</title>
</head>
<body>

	<h1>タスク編集完了画面</h1>
	<hr>
	<h2>タスクの編集に成功しました</h2>

	<%-- form --%>
	<form action="menu.jsp">
		<input type="submit" value="メニュー画面へ戻る">
	</form>

	<%-- セッションスコープを無効化（taskId, 各Bean --%>
	<%
		session.removeAttribute("taskId");
		session.removeAttribute("statusBean");
		session.removeAttribute("userBean");
		session.removeAttribute("categoryBean");
		session.removeAttribute("taskBean");
	%>

</body>
</html>