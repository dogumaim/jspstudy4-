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
<h1>다운로드 목록</h1>
<ul>
	<c:if test="${empty files }">
		<li>등록된 파일이 없습니다.</li>
	</c:if>
	<c:forEach var="f" items="${files }">
		<c:url var="downUrl" value="fileDown.do">
			<c:param name="filename">${f.name }</c:param>
		</c:url>
		<li><a href="${downUrl }">${f.name }</a></li>
	</c:forEach>
</ul>
</body>
</html>