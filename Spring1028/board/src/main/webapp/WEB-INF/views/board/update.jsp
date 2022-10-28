<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}" />   
<!DOCTYPE html>
<html>
<head>
<title>boardupdate</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="container mt-3">
  <ul class="nav nav-pills">
    <li class="nav-item">
      <a class="nav-link active" href="${root}/board/list">글목록</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="${root}/board/write">글쓰기</a>
    </li>
     <li class="nav-item">
      <a class="nav-link active" href="${root}/board/alist">비동기 리스트</a>
    </li>
  </ul>
</div>
<div class="container mt-3">
  <h2 class="text-center text-success">목록수정</h2>
  
 <form action="${root}/board/update" method="post">
  <div class="mb-3 mt-3">
    <label for="userid" class="form-label">작성자:</label>
    <input type="text" class="form-control" id="userId" placeholder="Enter userid" name="userId" value="${list.userId }" readonly>
  </div>
   <div class="mb-3 mt-3">
    <label for="subject" class="form-label">제목:</label>
    <input type="text" class="form-control" id="subject" placeholder="Enter subject" name="subject" value="${list.subject }" >
  </div>
  <div class="mb-3 mt-3">
      <label for="content">내용:</label>
      <textarea class="form-control" rows="10" id="content" name="content" >${list.content }</textarea>
    </div>
    <input type="hidden" id="articleNo"  name="articleNo"value="${list.articleNo }">
  <button type="submit" class="btn btn-primary">수정완료</button>
</form>
</div>
</body>
</html>