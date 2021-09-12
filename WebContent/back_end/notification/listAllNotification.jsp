<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.*"%>
<%@ page import="com.shop.model.*"%>
<!DOCTYPE html>
<%
	NotificationService notificationSvc = new NotificationService();
    List<NotificationVO> list = notificationSvc.getall();
    pageContext.setAttribute("list",list);
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test="${not empty errorMsgs}">
	<font style="color:red">請修正以下錯誤:</font>
	<ul>
		<c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message}</li>
		</c:forEach>
	</ul>
</c:if>

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
	<c:forEach var="notificationVO" items="${list}" varStatus="list">
		
		<tr>
			<td>${notificationVO.notification_id}</td>
			<td>${notificationVO.title}</td>
			<td>${notificationVO.text}</td>
			<td>
				<img alt="" src="<%=request.getContextPath()%>/news/getpic.do?picno=${notificationVO.notification_id}">
			</td>
			<td>${notificationVO.start_time}</td>
			<td>${notificationVO.end_time}</td>
			<td>${notificationVO.create_time}</td>
			 
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/notification/notification.do" style="margin-bottom: 0px;">
			     <input type="submit" value="修改">
			     <input type="hidden" name="notification_id"  value="${notificationVO.notification_id}">
			     <input type="hidden" name="action"	value="getOne_For_Update"></FORM>
			</td>
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/notification/notification.do" style="margin-bottom: 0px;">
			     <input type="submit" value="刪除">
			     <input type="hidden" name="notification_id"  value="${notificationVO.notification_id}">
			     <input type="hidden" name="action" value="delete"></FORM>
			</td>
		</tr>
	</c:forEach>
</table>

</body>
</html>