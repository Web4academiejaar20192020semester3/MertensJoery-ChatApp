<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: joery
  Date: 24/05/2019
  Time: 19:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<jsp:include page="head.jsp">
    <jsp:param name="title" value="Home"/>
</jsp:include>
<body>
<jsp:include page="header.jsp">
    <jsp:param name="title" value="Home"/>
</jsp:include>
<main>
    <c:if test="${errors.size()>0 }">
        <div class="danger">
            <ul>
                <c:forEach var="error" items="${errors }">
                    <li>${error }</li>
                </c:forEach>
            </ul>
        </div>
    </c:if>
<form method="post" action="Controller?action=AddPerson">
    <p>
        <label for="email">Your email </label>
        <input type="text" id="email" name="email" value="" required>
    </p>
    <p>
        <label for="name">Your name</label>
        <input type="text" id="name" name="name" value=""required>
    </p>
    <p>
        <label for="Fname">Your first name</label>
        <input type="text" id="Fname" name="Fname" value=""required>
    </p>
    <p>
        <label for="password">Your password</label>
        <input type="password" id="password" name="password" value=""required>
    </p>
    <p>
        <label for="passwordR">Your password again</label>
        <input type="password" id="passwordR" name="passwordR" value=""required>
    </p>
    <p>
        <label for="gender">Your gender</label>
        <input type="text" id="gender" name="gender" value=""required>
    </p>
    <p>
        <label for="age">Your age</label>
        <input type="int" id="age" name="age" value=""required>
    </p>
    <p>
        <input type="submit" id="registerButton" value="Register">
    </p>
</form>
</main>
<jsp:include page="footer.jsp">
    <jsp:param name="title" value="Home"/>
</jsp:include>
</body>
</html>
