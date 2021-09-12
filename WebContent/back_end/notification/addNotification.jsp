<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.shop.model.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
NotificationVO notificationVO = (NotificationVO) request.getAttribute("notificationVO");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>addNotificationVO</title>
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


<form method="post" action="<%= request.getContextPath()%>/notification/notification.do" name="form1" enctype="multipart/form-data">
<table>
	
	<tr>
		<td>公告標題:</td>
		<td><input type="TEXT" name="title" size="45"
			 value="<%= (notificationVO==null)? "公告標題" : notificationVO.getTitle()%>" /></td>
	</tr>
	<tr>
		<td>公告內文:</td>
		<td>
		<textarea class="form-control" name="text" placeholder="Message" rows="14"><%= (notificationVO==null)? "優惠訊息" : notificationVO.getText()%></textarea>
		</td>
	</tr>
	<tr>
		<td>公告圖片:</td>
		<td><input type="file" name="picture" size="45"
			 value="<%= (notificationVO==null)? "" : notificationVO.getPicture()%>" /></td>
	</tr>
	<tr>
		<td>開始時間:</td>
		<td><input type="date" name="start_time" id="f_date1" type="text"></td>
	</tr>
	<tr>
		<td>結束時間:</td>
		<td><input type="date" name="end_time" id="f_date1" type="text"></td>
	</tr>
	<tr>
		<td>創建時間:</td>
		<td><input type="date" name="create_time" id="f_date1" type="text"></td>
	</tr>
	
</table>
<br>
<input type="hidden" name="action" value="insert">
<input type="submit" value="送出新增">
</form>

</body>
</html>