<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <title>All Items</title>
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
        <th>Rent Book</th>
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
                <a href="${pageContext.request.contextPath}/rent/getBook?book_id=${book.id}">Rent Book</a>
            </td>
        </tr>
    </c:forEach>
</table>
<hr>
<form action="${pageContext.request.contextPath}/book/find" method="get">
    <td>Find by title:</td>
    <td><input value="${title}" name="title"/></td>
    <button type="submit"> Find</button>
</form>
</body>
</html>

