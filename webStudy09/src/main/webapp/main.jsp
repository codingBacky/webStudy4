<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>메인 페이지</h1>
	<h2>안녕하세요 ${loginUser.name }(${loginUser.userid })님 환영합니다✨✨🎉🎉</h2>
	<button type="submit" class="btn btn-primary">로그아웃</button>&nbsp;&nbsp;
    <button type="button" class="btn btn-danger" 
    		onclick="location.href='memberUpdate.do?userid=${loginUser.userid}'">회원정보 변경</button>&nbsp;&nbsp;
</body>
</html>