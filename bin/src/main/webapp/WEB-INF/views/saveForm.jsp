<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="layout/header.jsp" %>

<main>

<div ><h1>글쓰기 페이지</h1></div>
<hr/>
<form action="/save" method="post">
	<p>제목</p><input type="text" name="title" />
	<br/>
	<p>내용</p><textarea id="summernote" name="content"></textarea>
	<br/>
	<button class="btn btn-info">글쓰기 완료</button>
	
</form>

<script>
    $(document).ready(function() {
        $('#summernote').summernote();
    });
  </script>
</main>
	<%@ include file="layout/footer.jsp" %>
