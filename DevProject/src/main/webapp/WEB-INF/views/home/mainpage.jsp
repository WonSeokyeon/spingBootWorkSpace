<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>환영 페이지</title>
</head>
<body>
	<h1>
		환영합니다.<br>

		<spring:message code="welcome.message" /><br>
		<spring:message code="welcome.message" arguments="홍길동"/>
	</h1>
	

</body>
</html>