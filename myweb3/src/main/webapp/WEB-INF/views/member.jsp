<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script>
function page_open(){
	window.open('idCheck.do','idCheck','width=430', 'height=500');
}
</script>
<body>
<h1>member.jsp</h1>
<form name="memberInsert" action="memberMsg.do" method="post">
<fieldset>
	<legend>회원가입</legend>
	<label>아이디 : 
	<input type="text" name="id" readonly><input type="button" value="아이디 중복확인" onclick="page_open();" >
	</label>
	<br>
	<label>닉네임 :
	<input type="text" name="name">
	</label>
	<br>
	<label>비밀번호
	<input type="password" name="pwd">
	</label>
	<br>
	<label>E-mail
	<input type="text" name="email">
	</label>
	<br>
	<label>전화번호
	<input type="text" name="tel">
	</label>
	<br>
	<label>주소
	<input type="text" name="addr">	
	</label>
</fieldset>
	<div>
	<input type="submit" value="회원가입하기">
	<input type="reset" value="다시입력">
	</div>
</form>
</body>
</html>