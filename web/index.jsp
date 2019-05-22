<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
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
    <c:choose>
    <c:when test="${user!=null}">
        <p>Welcome ${user.getFirstName()}!</p>
        <form method="post" action="Controller?action=LogOut">
            <p>
                <input type="submit" id="logoutbutton" value="Log Out">
            </p>
        </form>
    </c:when>
    <c:otherwise>
        <form method="post" action="Controller?action=LogIn">
            <p>
                <label for="email">Your email </label>
                <input type="text" id="email" name="email" value="jan@ucll.be">
            </p>
            <p>
                <label for="password">Your password</label>
                <input type="password" id="password" name="password" value="t">
            </p>
            <p>
                <input type="submit" id="loginbutton" value="Log in">
            </p>
        </form>
    </c:otherwise>
    </c:choose>
    <ul>
        <c:forEach var="topic" items="${topics}">
        <li>
            <h4>${topic.getTopic()}</h4><table>
            <tr>
                <th>Name</th>
                <th>Response</th>
                <th>Rating</th>
            </tr>
            <c:forEach var="reply" items="${topic.getComments()}">

                <tr>
                    <td>${reply.getName()} </td>
                    <td>${reply.getComment()} </td>
                    <td>${reply.getRating()} </td>
                </tr>

            </c:forEach>
        </table>
            <form method="post" action="Controller?action=AddReply">
                <p>
                    <label for="name">Your name:</label>
                    <input type="text" id="name" name="name" value="">
                </p>
                <p>
                    <label for="comment">Your comment:</label>
                    <input type="text" id="comment" name="comment" value="">
                </p>
                <p>
                    <label for="rating">Your rating:</label>
                    <input type="number" id="rating" name="rating" value="">
                </p>
                <p>
                    <input type="text" id="topic" name="topic" value="${topic.getTopic()}" style="visibility: hidden; appearance: none; size: 0px ">
                </p>
                <p>
                    <input type="submit" id="replybutton" value="add reply">
                </p>
            </form>
        </li>

        </c:forEach></ul>


</main>
<jsp:include page="footer.jsp">
    <jsp:param name="title" value="Home"/>
</jsp:include>
</body>
</html>