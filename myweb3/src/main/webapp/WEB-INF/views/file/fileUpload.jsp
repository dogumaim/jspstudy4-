<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>파일 업로드 테스트</h1>
<form name="fileUpload1"  action="fileUpload1.do" method="post" enctype="multipart/form-data">
	<fieldset>
		<legend>파일업로드1(@requestParam이용)</legend>
		<ul>
			<li>작성자:<input type="text" name="writer"></li>
			<li>올릴파일:<input type="file" name="upload"></li>
		</ul>
		<div><input type="submit" value="파일올리기"></div>
	</fieldset>
</form>
<form name="fileUpload2"  action="fileUpload2.do" method="post" enctype="multipart/form-data">
	<fieldset>
		<legend>파일업로드2(MultipartRequest이용)</legend>
		<ul>
			<li>작성자:<input type="text" name="writer"></li>
			<li>올릴파일:<input type="file" name="upload"></li>
		</ul>
		<div><input type="submit" value="파일올리기"></div>
	</fieldset>
</form>
<form name="fileUpload3"  action="fileUpload3.do" method="post" enctype="multipart/form-data">
	<fieldset>
		<legend>파일업로드3(DTO이용)</legend>
		<ul>
			<li>작성자:<input type="text" name="writer"></li>
			<li>올릴파일:<input type="file" name="upload"></li>
		</ul>
		<div><input type="submit" value="파일올리기"></div>
	</fieldset>
</form>
<form name="fileUpload4"  action="fileUpload4.do" method="post" enctype="multipart/form-data">
	<fieldset>
		<legend>파일업로드4(다중)</legend>
		<ul>
			<li>작성자:<input type="text" name="writer"></li>
			<li>올릴파일:<input type="file" name="upload"></li>
			<li>올릴파일:<input type="file" name="upload"></li>
			<li>올릴파일:<input type="file" name="upload"></li>
		</ul>
		<div><input type="submit" value="파일올리기"></div>
	</fieldset>
</form>
</body>
</html>