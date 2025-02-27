<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
int res = (int) request.getAttribute("res");
%>
<html>
<head>
<meta charset="UTF-8">
<title>削除完了画面</title>
</head>
<body></body>
	<h1>タスク削除</h1>
	<hr>
	<h1>以下のタスクを削除しました</h1>

	<br>
	<table border="1">
		<tr>
			<th>タスク名</th>
			<th>カテゴリー情報</th>
			<th>期限</th>
			<th>担当者情報</th>
			<th>ステータス情報</th>
			<th>ステータス</th>
			<th>メモ</th>
		</tr>
		<tr>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
		</tr>
	</table>
	<form action="">
		<input type="submit" value="メニュー画面へ">
	</form>
</body>
</html>