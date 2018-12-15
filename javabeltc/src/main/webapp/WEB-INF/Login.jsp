<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" 
uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>

<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <link rel="stylesheet" type="text/css" media="screen" href="../css/test.css" />
    <script type="text/javascript" src="../js/test.js"></script>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>

<body>
    <div class="login-page">
        <div class="form">

            
            <form:form action="/registration" method="POST" modelAttribute="user" class="register-form">
            
            <form:errors path="name"/>
            <form:input class="{{category}}" path="name" placeholder="Name" />
            
            <form:errors path="email"/>
            <form:input class="{{category}}" type="email" path="email" placeholder="Email" />
            
            <form:errors path="password"/>
            <form:errors path="passwordConfirmation"/>
            <form:password class="{{category}}" path="password" placeholder="Password" />
            
                <form:password class="{{category}}" path="passwordConfirmation" placeholder="Confirm Password" />

                <form:button>Register</form:button>

                <p class="message">Already registered? <a href="#">Sign In</a></p>
            </form:form>

            <form action="/login" modelAttribute="user" method="post" class="login-form">

                <p class="{{category}}">
                    <c:out value="${error}" />
                </p>

                <input class="{{category}}" type='text' name="email" placeholder="Email">

                <input class="{{category}}" type='password' name="password" placeholder="Password">

                <button>Login</button>

                <p class="message">Not registered? <a href="#">Create an account</a></p>
            </form>
        </div>
    </div>
</body>

</html>