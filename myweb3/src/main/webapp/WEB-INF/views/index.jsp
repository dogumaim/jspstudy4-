<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script>
function page_open(){
	window.open('login.do','login','width=350 height=200');
}
function openLogin(){
	window.open('loginForm2.do','login2','width=450,height=300');
}
</script>
<body>
<h1>index.jsp 메인페이지입니다.</h1>
<c:if test="${empty sessionScope.userid }">
	<div><a href="javascript:page_open();">로그인</a>||<a href="memberJoin.do">회원가입</a></div>
</c:if>
<c:if test="${not empty sessionScope.userid }">
	<div>${sessionScope.userid}님 환영합니다!||<a href="logout.do">로그아웃</a></div>
</c:if>	
<hr>
<c:if test="${empty sessionScope.sid }">
<div><a href="javascript:openLogin();">로그인</a> | <a href="memberJoin.do">회원가입</a> (강사님)</div> 
</c:if>
<c:if test="${! empty sessionScope.sid }">
	<div>${sessionScope.sname }님 로그인중... | <a href="logout2.do">로그아웃</a></div>
</c:if>
<ul>
	<li><a href="hello.do">Spring MVC</a></li>.
	<li><a href="memoWrite.do">메모 작성하기</a></li>
	<li><a href="member.do">회원가입 하기</a></li>
	<li><a href="memberList2.do">회원 목록보기</a></li>	
	<li><a href="memberJoin.do">회원가입(강사님 해설)</a></li>
	<li><a href="memberList.do">회원 목록(강사님 해설)</a></li>
	<li><a href="productOrder.do">편의점 발주 시스템</a></li>
	<c:url var="paramUrl" value="paramTest.do">
		<c:param name="idx">3</c:param>
		<c:param name="str">spring</c:param>
	</c:url>
	<li><a href="${paramUrl }">파라미터 테스트</a></li>
	<li><a href="cookieView.do">쿠키 확인하기</a></li>
	<li><a href="cookieMake.do">쿠키 저장하기</a></li>
	<li><a href="sessionView.do">세션 확인하기</a></li>
	<li><a href="sessionMake.do">세션 저장하기</a></li>
	<li><a href="viewTest.do">명시적 뷰 지정</a></li>
	<li><a href="view/viewOk.do">묵시적 뷰 지정</a></li>
	<li><a href="viewTest4.do">컨트롤러에서 또다른 명령어 호출</a></li>
	<li><a href="modelTest1.do">모델 테스트1(Map)</a></li>
	<li><a href="modelTest2.do">모델 테스트2(Model)</a></li>
	<li><a href="modelTest3.do">모델 테스트3(ModelMap)</a></li>
	<li><a href="model/modelOk.do">모델 테스트4(Map반환)</a></li>
	<li><a href="model/modelOk.do">모델 테스트5(Model반환)</a></li>  <!-- dto, Model, Map  -->
	<li><a href="aniFindA.do">애니메이션 검색</a></li>
</ul>
</body>
</html>