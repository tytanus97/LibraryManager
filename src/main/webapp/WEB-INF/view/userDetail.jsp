<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page isELIgnored="false" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <title>User details</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <link href='<spring:url value="/resources/css/userDetail.css"/>' rel="stylesheet" >
</head>
<body>
<nav>
    <form:form method="POST" action="${pageContext.request.contextPath}/logout">
        <input type="submit" id="logout" class="btn btn-danger" value="Logout"/>
    </form:form>

    <h3 id="mybooks">My Details</h3>

    <form:form method="GET" action="${pageContext.request.contextPath}/">
        <input type="submit" id="back" class="btn btn-info" value="Back"/>
    </form:form>

</nav>
<section>
    <hr>
    <h4>Username:</h4><h4>${user.username}</h4><br>
    <h4>Email:</h4><h4>${user.email}</h4><br>
    <hr>
    <c:if test="${userBookList.size() != 0 }">
    <table class="table">

        <thead>
        <tr>
            <th scope="col">Title</th>
            <th scope="col">Author</th>
            <th scope="col">Description</th>
            <th scope="col">Details</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="book" items="${userBookList}">
            <c:url var="bookDetails" value="/book/details">
                <c:param name="bookId" value="${book.id}"/>
            </c:url>

            <tr class="book-row">

                <td>${book.title}</td>
                <td>${book.author.name}</td>
                <td>${book.description}</td>
                <td><form:form action="${bookDetails}" method="POST">
                    <input type="submit" class="btn btn-success" value="Details"/>
                </form:form>
                </td>

            </tr>
        </c:forEach>
        </tbody>
    </table>
    </c:if>
    <c:if test="${userBookList.size() == 0 }"><h1 id="booklistempty">Your book list is empty</h1></c:if>
</section>
</body>
</html>