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

</head>
<body>
<nav>
    <form:form method="POST" action="${pageContext.request.contextPath}/logout">
        <input type="submit" id="logout" class="btn btn-danger" value="Logout"/>
    </form:form>
    <c:url var="showUserDetails" value="/user/showUserDetails">
        <c:param name="userName" value="${pageContext.request.userPrincipal.name}"/>
    </c:url>

    <h3 id="mybooks">My books</h3>

    <form:form method="POST" action="${showUserDetails}">
        <input type="submit" id="userDetails" class="btn btn-warning" value="<security:authentication property='principal.username'/>"/>
    </form:form>


</nav>
<section>
    <h2>Available books</h2>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Title</th>
            <th scope="col">Author</th>
            <th scope="col">Description</th>
            <th scope="col">Amount</th>
            <th scope="col">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="book" items="${books}">
            <tr class="book-row">
                <td>${book.title}</td>
                <td>${book.author.name}</td>
                <td>${book.description}</td>
                <td>${book.amount}</td>
                <td><button  class="btn btn-secondary">Details</button><button class="btn btn-warning">Borrow</button></td>
            </tr>
        </c:forEach>
        </tbody>

    </table>
</section>
</body>
</html>