<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<h1>
	안승 방명록입니다.
</h1>

<P> ${serverTime}에 방문하셨습니다. </P>

<a href=".//guestlist">목록보기</a>
<a href="./guestwrite">방명록쓰기</a>
<br/>
<img src="${root}/img/ahn.jpg" width="30%">
</body>
</html>