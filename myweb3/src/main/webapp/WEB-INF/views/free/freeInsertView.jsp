<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>자유게시판 글쓰기</h1>
<form name="Insert" action="freeInsert.do" method="post">
<fieldset>
	<legend>글쓰기</legend>
	<label>이름:<input type="text" name="writer"></label>
	<br>
	<label>제목:<input type="text" name="subject"></label>
	<br>
	<label>비밀번호:<input type="password"	name="pwd"></label>
	<br>
	<label>본문내용<br><textarea rows="20" cols="40" name="content"></textarea></label>
	<br>
	<span>
	<input type="reset" value="다시쓰기">
	<input type="submit" value="작성하기">
	</span>
</fieldset>
</form>
</body>
</html>