<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:set var="arr" value="${arr }"></c:set>

<table>
	<tr>
		<th>아이디</th>
		<th>이름</th>
		<th>비밀번호</th>
		<th>이메일</th>
		<th>전화번호</th>
		<th>주소</th>
	</tr>
<c:forEach var="arr2" items="${arr }">
	<tr>
		<td>${arr2.id }</td>
		<td>${arr2.name }</td>
		<td>${arr2.pwd }</td>
		<td>${arr2.email}</td>
		<td>${arr2.tel }</td>
		<td>${arr2.addr }</td>		
	</tr>
	</c:forEach>
</table>
<div style="width: 550px; text-align: center;">
	<form name="memberFind" action="memberList2.do">
	<input type="hidden" name="type" value="yes">
		<select name="fkey">
			<option value="1">ID</option>
			<option value="2">이름</option>
		</select>
		<input type="text" name="fvalue">
		<input type="submit" value="검색">
	</form>
</div>
</body>
</html>