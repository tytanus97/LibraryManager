<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>duasdasdas</title>
</head>
<body>
<h1>asdasfasdfasdfasd</h1>

<c:forEach var = "author" items = "${duppa}" >
    <tr>
        <td><c:out value="${author.id}" /></td>
        <td><c:out value="${author.name}"/></td>
        <td><c:out value="${author.style}"/></td>
    </tr>
<br>
</c:forEach>
</body>
</html>
