<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タスク登録画面</title>
</head>
<body>

<h1>タスク登録画面</h1>
<hr>
<h2>登録するタスクの情報を入力して下さい</h2><br>

	<%-- form --%>
	<form action="task-add-servlet" method="post">

		<%-- table --%>
		<table border=1>
			
			<%-- 登録項目 --%>
			<tr>
				<th>タスク名</th>
				<th>カテゴリ情報</th>
				<th>期限</th>
				<th>担当者情報</th>
				<th>ステータス情報</th>
				<th>メモ</th>
			</tr>
			
			<%-- 入力欄 --%>
			<tr>
				<%-- タスク名 --%>
				<td><input type="text" name="taskName"></td>
				
				<%-- カテゴリ情報 m_category --%>
				<td>	
					<select name="category">
						<option value="">新商品A：開発プロジェクト</option>
					</select>
				</td>
				
				<%-- 期限 --%>
				<td><input type="date" name="timeLimit"></td>
		
				<%-- 担当者情報 m_user --%>
				<td>
					<select name="user">
						<option value="">サンプル田中</option>
					</select>
				</td>
				
				<%-- ステータス情報 m_status --%>
				<td>	
					<select name="status">
						<option value="">未着手</option>
					</select>
				</td>
				
				<%-- メモ --%>
				<td>
					<input type="textarea" name="memo">
				</td>
			</tr>
			
		</table>
		<br>
		
		<%-- table 送信/リセットボタン --%>
		<table>
		 <tr>
		 	<th><input type="submit" value="登録"></th>
		 	<th><input type="reset" value="リセット"></th>
		 	<th>
		 </tr>

		</table>		
	</form>
	
</body>
</html>