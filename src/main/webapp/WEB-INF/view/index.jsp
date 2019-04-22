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

    <h3 id="mybooks">Logged in as: <security:authentication property='principal.username'/></h3>

    <form:form method="POST" action="${showUserDetails}">
        <input type="submit" id="userDetails" class="btn btn-warning" value="My details"/>
    </form:form>


</nav>
<section class="scrollable">
    <h2>Available books</h2>
    <table class="table table-fixed">
        <thead>
        <tr>
            <th scope="col">Title</th>
            <th scope="col">Author</th>
            <th scope="col">Description</th>
            <th scope="col">Amount</th>
            <th scope="col">Borrow</th>
            <th scope="col">Details</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="book" items="${books}">
            <c:url var="addBookToUser" value="/user/addBook">
                <c:param name="userName" value="${pageContext.request.userPrincipal.name}"/>
                <c:param name="bookId" value="${book.id}"/>
            </c:url>
            <c:url var="bookDetails" value="/book/details">
                <c:param name="bookId" value="${book.id}"/>
            </c:url>
            <tr class="book-row">
                <td>${book.title}</td>
                <td>${book.author.name}</td>
                <td>${book.description}</td>
                <td>${book.amount}</td>
                <td><form:form action="${addBookToUser}" method ="POST">
                    <input type = "submit" class="btn btn-secondary" value="Borrow">
                    </form:form>
                    <c:if test="${bookInBookList != null}">
                    <script>alert("${bookInBookList}")</script>
                    ${bookInBookList = null}
                    </c:if>
                </td>
                <td>
                    <form:form action="${bookDetails}" method="POST">
                        <input type="submit" class="btn btn-success" value="Details"/>
                    </form:form>
                </td>
            </tr>
        </c:forEach>
        </tbody>

    </table>
</section>
</body>
</html>