<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>GuestBooks</title>
	<style>
#customers {
  font-family: Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

#customers td, #customers th {
  border: 1px solid #ddd;
  padding: 8px;
}

#customers tr:nth-child(even){background-color: #f2f2f2;}

#customers tr:hover {background-color: #ddd;}

#customers th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #04AA6D;
  color: white;
}
</style>
</head>
<body>

<c:if test="${not empty login}">
[${login.userName }]님 반갑습니다. 
<a href='./guestlist'>게시판 보기</a>
<a href='./guestwrite'>게시판 글쓰기</a>
<a href='./logout'>로그아웃</a>
</c:if>

<c:if test="${empty login}">
<a href='./guestlist'>게시판 보기</a>
<a href='./guestwrite'>게시판 글쓰기</a>
<a href='./'>로그인</a>
</c:if>
<h1>
	안녕하세요 인재 게시판입니다.
</h1>
	<table id="customers">
  <tr>
    <th>글번호</th>
    <th>작성자</th>
    <th>제목</th>
  </tr>
  <c:if test = "${empty books}">
  	<tr>
  	<td colspan="3">작성된 글이 없습니다.</td>
  	</tr>
  </c:if>
  <c:forEach items="${books}" var="book" varStatus="vs"> 
  <tr>
    <td>${vs.count}</td>
    <td>${book.userId}</td>
    <td><a href="./guestdetail?articleNo=${vs.count}">${book.subject}</a></td>
  </tr>
  </c:forEach>
</table>
	<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
