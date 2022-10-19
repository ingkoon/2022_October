<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>guestbook</title>
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
<meta>

<body>
<%@ include file="/WEB-INF/views/common/header.jsp" %>


<div id = "main">
<h1>안승사 방명록</h1>

	<table id = "customers">
		<tr>
			<th>작성자</th>
			<td><input type="text" name="articleNo" readonly value ="${book.articleNo}"></td>	
		</tr>
	
		<tr>
			<th>작성자</th>
			<td><input type="text" name="userId" value ="${book.userId}"></td>	
		</tr>
		<tr>		
			<th>제목</th>
			<td><input type="text" name="subject" value ="${book.subject}"></td>			
		</tr>
		<tr>
			<th>시간</th>
			<td><input type="text" name="subject" value ="${book.regTime}"></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea rows="10" cols="50" name="content">${book.content}</textarea></td>					
		</tr>
		<td colspan="2"><a href="board/boardupdate">수정</a></td>	
	</table>

</div>
	
<P>  The time on the server is ${serverTime}. </P>

<a href="./guestlist">돌아가기</a>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>
