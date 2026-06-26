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
	<h1>home6</h1>
	<c:redirect url="http://localhost:8080/home1" /> 
	<p>서버에서 보내준 데이터 출력 ${serverTime}.</p>
	

	
</body>
</html>