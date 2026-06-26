<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>\
<%@ page import="java.text.DateFormat"%> 
<%@ page import="java.util.Date"%> 
<%@ page import="java.util.Locale"%> 
<%
/*스크립트 자바코드를 사용할수 있다.*/
 Date date = new Date();
 	String serverTime2 = date.toString();
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 헤더 내용 가져온다. -->
	<%@	include file="./../includes/header.jsp"%>
	<p>서버에서 보내준 데이터 출력 ${serverTime}.</p>
	<p>JSP코드안에서 자바를 활용하여 데이터 출력 <%= serverTime2 %></p>
	<!-- 푸터 내용 가져온다. -->
	<%@	include file="./../includes/footer.jsp"%>

</body>
</html>