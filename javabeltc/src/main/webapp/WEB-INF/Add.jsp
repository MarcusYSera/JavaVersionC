<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" 
uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>

<head>
	<link rel="stylesheet" type="text/css" media="screen" href="../css/add.css" />
	<script type="text/javascript" src="../js/test.js"></script>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>

<body>
	<div class="ideaCreation">
		<a href="/dash">Return to Dash</a>
	<h1>Create a new idea</h1>
	<form:form action="/idea/create" method="POST" modelAttribute="createIdea">
	<p><form:errors path="content"/></p>
			<input type="hidden" name="user" value="${user.id}">
			Content: <form:input path="content"/>
			<p><form:button>Create</form:button></p>
		</form:form>
	</div>
</body>

</html>