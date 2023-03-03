<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
h1{
	text-align: center;

}

</style>
<body>
<h1>자유게시판</h1>
<table border="1" width="550" cellspacing="0">
	<thead>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>조회수</th>
			<th>작성날짜</th>
		</tr>
	</thead>
	<tbody>
	
			<c:if test="${empty arr }">
			<tr>
				<td colspan="5" align="center">작성된 게시글이 없습니다.</td>
			</tr>
			</c:if>
			<c:if test="${! empty arr }">
				<c:forEach var="dto" items="${arr }">
				<tr>
					<td>${dto.idx }</td>
					<td>${dto.subject }</td>
					<td>${dto.writer }</td>
					<td>${dto.readnum }</td>
					<td>${dto.writedate }	</td>
				</tr>	
				</c:forEach>
			</c:if>
		
	</tbody>
</table>
<div>
<input type="button" value="게시글 등록하기" onclick="location.href='freeInsertView.do'">
</div>
</body>
</html>