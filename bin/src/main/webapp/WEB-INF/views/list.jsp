<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="layout/header.jsp"%>
<main>
	<h1>게시글목록</h1>
	<hr />
	<table class="table table-striped table-responsive-md btn-table">

		<thead>
			<tr>
				<td>ID</td>
				<td>TITLE</td>
				<td>CONTENT</td>
				<td>READCOUNT</td>
				<td>CREATEDATE</td>
			</tr>
		</thead> 

		<tbody>

				<c:forEach var="board" items="${boards.content}">
				<tr>
					<th scope="row">${board.id}</th>
					<td><a href="/board/${board.id}">${board.title}</a></td>
					<td>${board.content}</td>
					<td>${board.readCount}</td>
					<td>${board.createDate}</td>
				</tr>
				</c:forEach>
			
		</tbody>

	</table>


	<h1>현재 페이지: ${boards.pageable.pageNumber}</h1>
	<ul class="pagination" id="pagelist">


		<li class="page-item"><a class="page-link"
			href="/list?page=${boards.pageable.pageNumber-1 }">Previous</a></li>


		<li class="page-item"><a class="page-link"
			href="/list?page=${boards.pageable.pageNumber+1 }">Next</a></li>

	</ul>


</main>
<br>
<br>
<hr />

<%@ include file="layout/footer.jsp"%>
