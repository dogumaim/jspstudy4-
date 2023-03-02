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
<h1>회원 내역</h1>
<table border="1" cellspacing="0" width="550">
	<thead>
		<tr>
			<th>회원번호</th>
			<th>ID</th>
			<th>이름</th>
			<th>E-mail</th>
			<th>가입날짜</th>
		</tr>	
	</thead>
	<tbody>
		<c:if test="${empty arr }">
			<tr>
				<td colspan="5" align="center">
				등록된 회원이 없습니다.
				</td>
			</tr>
		</c:if>
		<c:forEach var="dto" items="${arr }">
			<tr>
				<td>${dto.idx }</td>
				<td>${dto.id }</td>
				<td>${dto.name }</td>
				<td>${dto.email }</td>
				<td>${dto.joindate	 }</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<form name="fm" action="search.do">
<fieldset>
	<legend>검색</legend>
	<select name="search" >
		<option value="1">ID</option>
		<option value="2">이름</option>
	</select>
	<input type="text" name="searchtext">
	<input type="submit" value="검색하기">
</fieldset>
</form>
</body>
</html>