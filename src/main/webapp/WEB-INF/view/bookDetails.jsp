<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page isELIgnored="false" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <title>Home</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <link href='<spring:url value="/resources/css/style1.css"/>' rel="stylesheet" >
    <style>
        #back {
            margin-left:20%;
            float:  left;
            margin-top:1%;
        }
    </style>

</head>
<body>
<nav>
    <form:form method="POST" action="${pageContext.request.contextPath}/logout">
        <input type="submit" id="logout" class="btn btn-danger" value="Logout"/>
    </form:form>

    <h3 id="mybooks">Logged in as: <security:authentication property='principal.username'/></h3>

    <form:form method="GET" action="${pageContext.request.contextPath}/">
        <input type="submit" id="back" class="btn btn-info" value="Back"/>
    </form:form>


</nav>
<section class="table-wrapper-scroll-y my-custom-scrollbar">
    <hr>
    <h2>Book details</h2>
    <h3>Tittle: ${book.title}</h3><br/>
    <h3>Author: ${book.author.name}</h3><br/>
    <h3>Description: ${book.description}</h3><br/>
    <h3>Copies left: ${book.amount}</h3><br/>
    <c:url var="addBookToUser" value="/user/addBook">
        <c:param name="userName" value="${pageContext.request.userPrincipal.name}"/>
        <c:param name="bookId" value="${book.id}"/>
    </c:url>
    <form:form action="${addBookToUser}" method ="POST">
    <input type = "submit" class="btn btn-secondary" value="Borrow">
    </form:form>
    <hr>

</section>
</body>
</html>