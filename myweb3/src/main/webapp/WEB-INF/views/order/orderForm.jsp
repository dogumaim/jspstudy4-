<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>편의점 상품 발주 시스템</h1>

<form name="orderForm" action="productOrder.do" method="post">
상품1 : 상품번호-<input type="text" name="products[0].proidx">/
	   상품명-<input type="text" name="products[0].proname">/
	   수량-<input type="text" name="products[0].pronum">/
	   비고-<input type="text" name="products[0].bigo"><br>
상품2 : 상품번호-<input type="text" name="products[1].proidx">/
	   상품명-<input type="text" name="products[1].proname">/
	   수량-<input type="text" name="products[1].pronum">/
	   비고-<input type="text" name="products[1].bigo"><br>
상품3 : 상품번호-<input type="text" name="products[2].proidx">/
	   상품명-<input type="text" name="products[2].proname">/
	   수량-<input type="text" name="products[2].pronum">/
	   비고-<input type="text" name="products[2].bigo"><br>
<hr>
매장명:<input type="text" name="marketinfo.marketname"><br>
매장주소:<input type="text" name="marketinfo.marketaddr"><br>
매장전화번호:<input type="text" name="marketinfo.markettel"	><br>
<input type="submit" value="발주">	   

</form>
</body>
</html>