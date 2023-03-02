<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>인기검색어 :
	<c:forEach var="keyword" items="${keywords }">
		${keyword }&nbsp;&nbsp;
	</c:forEach>
</div>
<form name="animeB">
	<fieldset>
		<legend>애니메이션 검색</legend>
		<select name="cate">
			<c:forEach var="ca" items="${cate }">
				<option value="${ca }">${ca }</option>
			</c:forEach>
		</select>
		<input type="text" name="findValue">
		<input type="submit" value="검색">
	</fieldset>
</form>
<hr>
<h1>animeB.jsp만의 독립적 컨텐츠</h1>
</body>
</html>