<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.shop.model.*"%>
<!DOCTYPE html>
<%
NotificationVO notificationVO = (NotificationVO)request.getAttribute("notificationVO"); 
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
	<tr>
		<th>公告ID</th>
		<th>公告標題</th>
		<th>公告內文</th>
		<th>公告圖片</th>
		<th>開始時間</th>
		<th>結束時間</th>
		<th>創建時間</th>
	</tr>
	<tr>
		<td><%=notificationVO.getNotification_id()%></td>
		<td><%=notificationVO.getTitle()%></td>
		<td><%=notificationVO.getText()%></td>
		<td><img alt="" src="<%=request.getContextPath()%>/notification/getpic.do?picno=${notificationVO.notification_id}"></td>
		<td><%=notificationVO.getStart_time()%></td>
		<td><%=notificationVO.getEnd_time()%></td>
		<td><%=notificationVO.getCreate_time()%></td>
	</tr>
</table>
</body>
</html>