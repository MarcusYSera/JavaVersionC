<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" 
uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>

<head>
	<link rel="stylesheet" type="text/css" media="screen" href="../css/test.css" />
	<script type="text/javascript" src="../js/test.js"></script>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>

<body>
	<div class="editPage">

		<h1>
			${viewIdea.content}
		</h1>
		<form:form action="/ideas/edit/here/${viewIdea.id}" method="POST" modelAttribute="editTheIdea">
			<input type="hidden" name="id" value="${viewIdea.id}">
			<input type="hidden" name="user" value="${viewIdea.user.id}">
			<form:errors path="content"/>
			<p>
				Content:
				<form:input path="content" />
			</p>
			<p>
				<form:button>Update</form:button>
			</p>
		</form:form>
		<p>
			<a href="/ideas/delete/${viewIdea.id}"><button>Delete</button></a>
		</p>
	</div>

	<p>
		<a href="/dash">return to dash</a>
	</p>
	</div>
</body>

</html>