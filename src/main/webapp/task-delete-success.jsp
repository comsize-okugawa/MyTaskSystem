<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.List, java.util.ArrayList, model.entity.UserStatusCategoryTaskBean"%>
<!DOCTYPE html>
<% List<UserStatusCategoryTaskBean> list = (List) request.getAttribute("list");%>
<html>
<head>
<meta charset="UTF-8">
<title>削除完了画面</title>
</head>
<body>
	<h1>タスク削除</h1>
	<hr>
	<h1>以下のタスクを削除しました</h1>
	<br>
	   <%
		for (UserStatusCategoryTaskBean i : list) {
		%>
	<table border="1">
		<tr>
			<th>タスク名</th>
			<th>カテゴリー情報</th>
			<th>期限</th>
			<th>担当者情報</th>
			<th>ステータス情報</th>
			<th>メモ</th>
		</tr>
		<tr>
			<td><%=i.getTaskName() %></td>
			<td><%=i.getCategoryName() %></td>
			<td><%=i.getLimitDate() %></td>
			<td><%=i.getTaskName() %></td>
			<td><%=i.getStatusName() %></td>
			<td><%=i.getMemo() %></td>
		</tr>
	</table>
	<%
		}
	%>
	<form action="menu.jsp">
		<input type="submit" value="メニュー画面へ">
	</form>
</body>
</html>