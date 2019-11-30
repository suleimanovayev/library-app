<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add book</title>
</head>
<body>
<jsp:include page="../views/header.jsp"/>
<form action="${pageContext.request.contextPath}/book/add" method="post">
    <table>
        <tr>
            <td>Book title:</td>
            <td><input value="${title}" name="title"/></td>
        </tr>
        <tr>
            <td>Year:</td>
            <td><input value="${year}" name="year"/></td>
        </tr>
        <tr>
            <td>Price:</td>
            <td><input value="${price}" name="price" type="number" step="0.01" min="0"/></td>
        </tr>
        <tr>
            <td></td>
            <td>
                <button type="submit">Confirm</button><br>
                <br>
                <a href="${pageContext.request.contextPath}/book/all">all books</a>
            </td>
        </tr>
    </table>
</form>
</body>
<