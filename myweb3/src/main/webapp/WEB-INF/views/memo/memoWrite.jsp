<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>메모 작성</h1>
<form name="memoWrite" action="memoWrite.do" method="post">
<fieldset>
	<legend>메모작성</legend>
	<ul>
		<li><label>번호</label>
		<input type="text" name="idx"></li>
		<li><label>작성자</label>
		<input type="text" name="writer"></li>
		<li><label>내용</label><br>
		<textarea rows="5" cols="35" name="content"></textarea></li>
	</ul>
	<div>
	<input type="submit" value="메모작성">
	<input type="reset" value="다시작성">
	</div>
</fieldset>
</form>
</body>
</html>