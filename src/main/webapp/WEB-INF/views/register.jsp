
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<form action="${pageContext.request.contextPath}/user/registration" method="post">
    <div class="container">
        <h1>Register</h1>
        <p>Please fill in this form to create an account.</p>
        <hr>
        <p>
            <label for="username"><b>Login</b></label>
            <input type="text" placeholder="Enter username" name="username" required>
        </p>
        <p>
            <label for="email"><b>E-mail</b></label>
            <input type="email" placeholder="Enter email" name="email" required>
        </p>
        <p>
            <label for="name"><b>First Name</b></label>
            <input type="text" placeholder="Enter firstname" name="firstName" required>
        </p>
        <p>
            <label for="surname"><b>Last Name</b></label>
            <input type="text" placeholder="Enter lastname" name="lastName" required>
        </p>
        <p>
            <label for="password"><b>Password</b></label>
            <input type="password" placeholder="Enter password" name="password" required>
        </p>
        <p><label for="repeatPassword"><b>Repeat password</b></label>
            <input type="password" placeholder="Repeat Password" name="repeatPassword" required>
        </p>

        <button type="submit" class="registerbtn">Register</button>
    </div>
</form>
</body>
</html>