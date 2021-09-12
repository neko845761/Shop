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
	<font style="color:red">�Эץ��H�U���~:</font>
	<ul>
		<c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message}</li>
		</c:forEach>
	</ul>
</c:if>

<form method="post" action="<%= request.getContextPath()%>/news/news.do" name="form1" enctype="multipart/form-data">
<table>
	<tr>
		<td>�o���ɶ�:</td>
		<td><input type="date" name="NEWS_TIME" id="f_date1" type="text"></td>
	</tr>
	<tr>
		<td>�������D:</td>
		<td><input type="TEXT" name="NEWS_TITLE" size="45"
			 value="<%= (newsVO==null)? "�u�f���D" : newsVO.getNEWS_TITLE()%>" /></td>
	</tr>
	<tr>
		<td>�������e:</td>
		<td>
		<textarea class="form-control" name="NEWS_CONTEXT" placeholder="Message" rows="14"><%= (newsVO==null)? "�u�f�T��" : newsVO.getNEWS_CONTEXT()%></textarea>
		</td>
		
	</tr>

</table>
<br>
<input type="hidden" name="action" value="insert">
<input type="submit" value="�e�X�s�W">
</form>

</body>
</html>