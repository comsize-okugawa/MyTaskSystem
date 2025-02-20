<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザー認証失敗画面</title>
</head>
<body>
<h1>ユーザー認証失敗画面</h1>
<hr>

タスクの編集・削除はタスクを登録したユーザーのみ可能です。
<br>
<br>
<form action="TaskListServlet" method="POST">
<input type="submit" name="taskList" value="タスク一覧表示画面へ">

</form>

</body>
</html>