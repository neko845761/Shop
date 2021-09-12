<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.shop.model.*"%>
<%
Account_memberVO account_membervo = (Account_memberVO)request.getAttribute("account_membervo");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
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

<form method="post" action="<%= request.getContextPath()%>/account_member/account_member.do" name="form1" enctype="multipart/form-data">
<table>
	<tr>
		<td>帳號:</td>
		<td><input type="TEXT" name="User_account" size="45" 
			 value="<%= (account_membervo==null)? "" : account_membervo.getUser_account()%>" /></td>
	</tr>
	<tr>
		<td>密碼:</td>
		<td><input type="TEXT" name="User_password" size="45"
			 value="<%= (account_membervo==null)? "" : account_membervo.getUser_password()%>" /></td>
	</tr>
</table>
<br>
<input type="hidden" name="action" value="login">
<input type="submit" value="登入">
</form>

</body>
</html>