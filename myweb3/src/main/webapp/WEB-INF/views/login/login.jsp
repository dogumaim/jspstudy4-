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
<form name="loginFrom" action="loginForm.do" method="get">
<fieldset>
	<legend>로그인하기</legend>
	<label>아이디:
	<input type="text" name="id" value="${saveid}"> 
	</label><br>
	<label>비밀번호:
	<input type="password" name="pwd">
	</label>
	<br>
	
	<input type="checkbox" name="checkbox" value="on" >아이디 기억하기
	<div>
	<input type="submit" value="로그인하기">
	</div>
</fieldset>
</form>
</body>
</html>