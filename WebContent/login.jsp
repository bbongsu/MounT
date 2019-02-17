<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>

<h1>로그인</h1>

<form action="loginAf" method="post">
	<input type="hidden" name="command" value="loginAf">
	아이디 : <input type="text" name="id" id="_id" maxlength="20">
	패스워드 : <input type="password" name="pwd" id="_pwd" maxlength="20" minlength="6" placeholder="6자리 이상 입력">
	<input type="submit" value="로그인">
</form>

<br>
<button onclick="location.href='register.jsp'">회원가입
		
</body>
</html>