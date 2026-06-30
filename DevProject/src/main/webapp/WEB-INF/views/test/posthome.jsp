<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/test/gohome1" method="post">
		boardNo: <input type="text" name="boardNo" value="1234"><br>
		title: <input type="text" name="title" value="1234"><br>
		content: <input type="text" name="content" value="100"><br>
		writer: <input type="text" name="writer" value="zeow"><br>
		coin: <input type="text" name="coin" value=100><br>
		gender: <br> 
		<input type="radio" name="gender" value="male"checked> Male<br>
		<input type="radio" name="gender"value="female"> Female<br>
		<input type="radio"name="gender" value="other"> Other<br> 
		nationality: 
		<select name="nationality" multiple> 
		<option value="Korea" selected>대한민국</option> 
		<option value="Germany">독일</option> 
		<option value="Australia">호주</option> 
		<option value="Canada">캐나다</option> 
		</select>
		<br> hobbyArray: <br> 
		<input type="checkbox" name="hobbyArray" value="Sports" checked> Sports<br> 
		<input type="checkbox" name="hobbyArray" value="Music"	checked> Music<br> 
		<input type="checkbox" name="hobbyArray" value="Movie"	checked> Movie<br> 
		
		foreigner: <input type="checkbox" name="foreigner" ><br> 
		
		<input type="submit" value="/test/gohome1">
	</form>
	<hr>
	<form action="/test/gohome1" method="get"> 
			address.postCode: <input type="text" name="address[0].postCode" /><br> 
			address.location: <input type="text" name="address[0].location" /><br> 
			
			address.postCode: <input type="text" name="address[1].postCode" /><br> 
			address.location: <input type="text" name="address[1].location" /><br> 
		<input type="submit" value="/test/gohome1 GET 방식"> 
		</form> 
</body>
</html>