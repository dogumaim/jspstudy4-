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
<h1>편의점 발주 내역</h1>
<h2>상품 목록</h2>
<ul>
	<c:if test="${empty orderDTO.products }">
	<li>발주 상품 내역이 없습니다.</li>
	</c:if>
	<c:forEach var="dto" items="${orderDTO.products }">
	<li>상품번호:${dto.proidx }/상품명:${dto.proname }/수량:${dto.pronum }/비고:${dto.bigo }</li>
	</c:forEach>
</ul>
<hr>
<h2>주문 매장 정보</h2>
<h3>매장명:${orderDTO.marketinfo.marketname }</h3>
<h3>매장주소:${orderDTO.marketinfo.marketaddr }</h3>
<h3>매장번호:${orderDTO.marketinfo.markettel }</h3>
</body>
</html>