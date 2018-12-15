<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" 
uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>

<head>
	<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.css">
	<link rel="stylesheet" type="text/css" media="screen" href="../css/scrollcss.css" />
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	 crossorigin="anonymous">
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>

<body>
	<div class="welcome">
		<h1>Welcome, ${user.name}</h1>
		<a href="/logout">Logout</a>
	</div>

	<div class="one">
		<h3>Ideas</h3>
		<a id="test" href="">Low Likes</a>
		<a href="">High Likes</a>
	</div>

	<div class="table-wrapper-scroll-y">
		<table class="table table-bordered table-striped" id="noms">
			<thead>
				<tr>
					<th scope="col">Idea</th>
					<th scope="col">Created By</th>
					<th scope="col">Likes</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ideasList}" var="a">
					<tr>
						<th scope="row">
							<a href="ideas/${a.id}">
								${a.content}
							</a>
						</th>
						<td>${a.user.name}</td>
						<td>
							<c:out value="${a.getUsers().size()}" />
							<input id="try" type="hidden" value="${a.getUsers().size()}" />
						</td>
						<td>
							<c:set var="liked" value="${user}" />
							<c:set var="unLiked" value="${a.getUsers()}" />
							<c:choose>
								<c:when test="${unLiked.contains(liked)}">
									<a href="/cancel/join/${a.id}">Unlike</a>
								</c:when>
								<c:otherwise>
									<a href="/join/${a.id}">Like</a>
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<a href="/ideas/new"><button>Create an Idea</button></a>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	 crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
	 crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
	 crossorigin="anonymous"></script>
	 <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.js"></script>
	<script type="text/javascript" src="../js/testersss.js"></script>
</body>

</html>