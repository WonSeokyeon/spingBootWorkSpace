<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Form Home</h3>
	<form action="/board/insert" method="post">
		<input type="submit" value="서버로 전송 /board/insert">
	</form>
	
		<form action="/board/select" method="get">
		<input type="submit" name = "regist">
	</form>
	
	<a href="/board/select?register">/board/select?registe</a> 
</body>
</html>