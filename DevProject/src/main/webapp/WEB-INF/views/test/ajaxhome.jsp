<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {

    // 1. 일반 POST 요청 버튼 이벤트
    $("#postBtn").on("click", function() {
        var boardNoVal = $("#boardNo").val();
        var boardObject = {
            boardNo : boardNoVal,
            title : $("#title").val(),
            content : $("#content").val(),
            writer : $("#writer").val()
        };

        $.ajax({
            type : "post",
            url : "/test/gohome1/" + boardNoVal, // URL 올바르게 수정 (/ 추가 및 gohome1 경로 지정)
            data : JSON.stringify(boardObject),
            contentType : "application/json; charset=utf-8",
            success : function(result) {
                console.log("result: " + result);
                if (result === "SUCCESS") {
                    alert("SUCCESS");
                }
            },
            error : function(xhr) {
                console.log("에러 발생: " + xhr.status); // 에러 확인용 로그 추가
            }
        }); 
    }); 

    // 2. 헤더를 포함한 POST 요청 버튼 이벤트
    $("#putHeaderBtn").on("click", function() {
        var boardNoVal = $("#boardNo").val();
        var boardObject = {
            boardNo : boardNoVal,
            title : $("#title").val(),
            content : $("#content").val(),
            writer : $("#writer").val()
        };

        $.ajax({
            type : "post", // 컨트롤러가 POST이므로 post로 전송
            url : "/test/gohome1/" + boardNoVal,
            headers : {
                "X-HTTP-Method-Override" : "PUT"
            },
            data : JSON.stringify(boardObject),
            contentType : "application/json; charset=utf-8",
            success : function(result) {
                console.log("result: " + result);
                if (result === "SUCCESS") {
                    alert("SUCCESS");
                }
            },
            error : function(xhr) {
                console.log("에러 발생: " + xhr.status);
            }
        });
    });

});
</script>
</head>
<body>
	<h1>AjaxHome</h1>
	<form>
		boardNo: <input type="text" name="boardNo" value="" id="boardNo"><br>
		title: <input type="text" name="title" value="" id="title"><br>
		content: <input type="text" name="content" value="" id="content"><br>
		writer: <input type="text" name="writer" value="" id="writer"><br>
	</form>
	<div>
		<button id="postBtn">수정(post)</button>
		<button id="putHeaderBtn">수정(post with header)</button>
	</div>
</body>
</html>