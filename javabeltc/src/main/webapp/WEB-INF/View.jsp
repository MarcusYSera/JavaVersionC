<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" 
uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>

<head>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
	<link rel="stylesheet" type="text/css" media="screen" href="../css/scrollcss.css" />
	<script type="text/javascript" src="../js/test.js"></script>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>

<body>
	<div>
		<h1>${viewIdea.content}</h1>
		<p>Created By: ${viewIdea.user.name}</p>
		<h2>Users who Liked your idea:</h2>

		<div class="table-wrapper-scroll-y">

			<table class="table table-bordered table-striped">
				<thead>
					<tr>
						<th scope="col">Name</th>
					</tr>
				</thead>
				<tbody>
						<c:forEach items="${viewIdea.users}" var="a">
							<tr>
								<th scope="row">${a.name}</th>
							</tr>
						</c:forEach>
				</tbody>
			</table>

		</div>
		<a href="/ideas/${id}/edit"><button>Edit</button></a>
		<a href="/dash">Return to DashBoard</a>

	</div>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	 crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
	 crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
	 crossorigin="anonymous"></script>
</body>

</html>