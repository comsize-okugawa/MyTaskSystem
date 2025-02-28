<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.List, java.util.ArrayList, model.entity.UserStatusCategoryTaskBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タスク削除確認</title>
</head>
<body>
<h1>タスク削除画面</h1>
	<hr>
	<h1>このタスク削除してもよろしいですか？</h1>
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
	<form action="TaskDeleteServlet" method="post">
	<input type="submit" value="削除する">
	</form>
</body>
</html>