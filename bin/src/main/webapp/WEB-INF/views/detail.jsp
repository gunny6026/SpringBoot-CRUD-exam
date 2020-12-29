<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="layout/header.jsp" %>
	<main>
	<h1>상세보기</h1>
	<hr />
	<table class="table table-dark table-striped" border="1">
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
			<tr>
				<td>${board.id}</td>
				<td><input id="title" type="text" value="${board.title}" /></td>
				<td><input id="content" type="text" value="${board.content}"/></td>
				<td>${board.readCount}</td>
				<td>${board.createDate}</td>
			</tr>
		</tbody>
	</table>
	<button class="btn btn-primary" onclick="deleteBoard(${board.id})">삭제</button>
	<button class="btn btn-warning" onclick="updateBoard(${board.id})">수정</button>
	</main>
	<br><br>
	<hr/>
	<script>
	function updateBoard(id){

		let title_el = document.querySelector("#title");
		let content_el = document.querySelector("#content");
		let title= title_el.value;
		let content = content_el.value;
	
		
			console.log("id",id);
			console.log("title",title_el);
			console.log("content",content_el);

			let board ={

					title: title,
					content: content

					};

			fetch("/board/"+id,{
				method: 'put',
				headers:{
						'Content-Type':'application/json; charset=utf-8',	
				},
				body:JSON.stringify(board),
				}).then(res=> res.text()).then(res=>{
					if(res=="ok"){
						alert("수정 완료ㅎㅎㅎㅎ")
						location.reload();
			
					}else{
						alert("수정실패!!!!!!");
					}
				});
		
		}
	
	function deleteBoard(id){
	
		fetch("/board/"+id,{
				method:"delete"
		 	}).then(res => res.text())
			.then(res =>{
				if(res=="ok"){
					alert("삭제성공");
					location.href="/list";
				}else{
						alert("삭제실패");
					}
				});

		}

	
	</script>
	
	<%@ include file="layout/footer.jsp" %>
