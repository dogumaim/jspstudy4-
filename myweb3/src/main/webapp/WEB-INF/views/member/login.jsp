<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form name="login" action="login2.do">
<fieldset>
	<legend>LOGIN</legend>
	<ul>
		<li><label>ID<input type="text" name="userid" value="${cookie.saveid.value }"></label></li>
		<li><label>Password<input type="password" name="userpwd"></label></li>
	</ul>
	<div align="right">
	<input type="submit" value="login">
	<input type="checkbox" name="saveid" value="no" ${empty cookie.saveid.value?'':'checked' } >아이디 기억하기
	</div>
</fieldset>
</form>
</body>
</html>