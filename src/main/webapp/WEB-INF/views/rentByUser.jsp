<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>Rented books</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<p>Books</p>
<hr>
<table border="1">
    <tr>
        <th>Title</th>
        <th>Year</th>
        <th>Price</th>
        <th>Info</th>
        <th>Authors</th>
        <th>Return Book</th>
    </tr>
    <c:forEach var="book" items="${books}">
        <tr>
            <td>${book.title}</td>
            <td>${book.year}</td>
            <td>${book.price}</td>
            </td>
            <td>
                <a href="${pageContext.request.contextPath}/book/${book.id}">INFO</a>
            </td>
            <td><${book.authors}"></td>
            <td>
                <a href="${pageContext.request.contextPath}/rent/returnBook?book_id=${book.id}">Return Book</a>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
