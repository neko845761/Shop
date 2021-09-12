<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
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

<ul>
  <li><a href='listAllNotification.jsp'>List</a></li>
  <li><a href='addNotification.jsp'>Add</a> a new Shop.</li>
  
  <li>
    <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/notification/notification.do" >
        <b>輸入消息編號:</b>
        <input type="text" name="notification_ID">
        <input type="hidden" name="action" value="getOne_For_Display">
        <input type="submit" value="送出">
    </FORM>
  </li>
 </ul> 
</body>
</html>