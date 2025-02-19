<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タスク一覧表示画面</title>
</head>
<body>

<h1>タスク一覧表示画面</h1>
<hr>
<table border>

<tr>
<th>タスク名</th>
<th>カテゴリ情報</th>
<th>期限</th>
<th>担当者情報</th>
<th>ステータス情報</th>
<th>メモ</th>
<th>削除</th>
<th>編集</th>
</tr>
<tr>
<td>タスクA</td>
<td>カテゴリA</td>
<td>YYYY-MM-DD</td>
<td>山田</td>
<td>ステータスA</td>
<td>メモA</td>
<td><form action=""><input type="button" value="削除"></form></td>
<td><form action=""><input type="button" value="編集"></form></td>
</tr>
<tr>
<td>タスクB</td>
<td>カテゴリB</td>
<td>YYYY-MM-DD</td>
<td>田中</td>
<td>ステータスB</td>
<td>メモB</td>
<td><form action=""><input type="button" value="削除"></form></td>
<td><form action=""><input type="button" value="編集"></form></td>
</tr>





</table>


</body>
</html>