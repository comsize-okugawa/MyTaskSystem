<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List,model.entity.UserStatusCategoryTaskBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タスク一覧表示画面</title>
</head>
<body>

<%
List<UserStatusCategoryTaskBean> taskList = (List<UserStatusCategoryTaskBean>) session.getAttribute("taskList");
%>

<h1>タスク一覧表示画面</h1>
<hr>
<table border>

<%
for(list : taskList){
%>
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
<td><%=list.getTaskName()%></td>
<td><%=list.getTaskName()%></td>
<td><%=list.getLimitDate()%></td>
<td><%=list.getUserName()%></td>
<td><%=list.getStatusName()%></td>
<td><%=list.getMemo()%></td>
<td><form action="JudgeUserDeleteServlet"><input type="button" name="delete" value="削除"></form></td>
<td><form action="JudgeUserEditServlet"><input type="button"  name="edit" value="編集"></form></td>
</tr>

<%
}
%>

</table>


</body>
</html>