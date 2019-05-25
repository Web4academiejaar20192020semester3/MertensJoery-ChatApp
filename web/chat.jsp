<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: joery
  Date: 14/05/2019
  Time: 17:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="head.jsp">
    <jsp:param name="title" value="Chat"/>
</jsp:include>
<body onload="getNewStatus();getFriends()">
<script src="js/jquery.js"></script>
<jsp:include page="header.jsp">
    <jsp:param name="title" value="Chat"/>
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
            <h3>Welcome ${user.getFirstName()}!</h3>
            <div id="showstatus"></div>
            <h3>Your friends:</h3>
            <table>
                <thead id="friendList">
                <tr>
                    <th>First name</th>
                    <th>Last name</th>
                    <th>Status</th>
                </thead>
                <tbody id="showFriends">

                </tbody>
            </table>
            <div class="msg_box" style="right:290px">
                <div class="msg_head">
                    <div class="close">x</div>
                </div>
                <div class="msg_wrap">
                    <div class="msg_body">
                    </div>
                    <div class="msg_footer"><textarea class="msg_input" rows="4"></textarea></div>
                </div>
            </div>
            <h3>Add Friend</h3>
            <p>
                <label for="userid">Your friend's email:</label>
                <input type="text" id="userid" name="userid" value="">
            </p>
            <p>
                <input type="button" id="friendbutton" value="Add Friend">
            </p>

            <h3>Change Status</h3>
            <p>
                <label for="status">Your prefered status:</label>
                <input type="text" id="status" name="status" value="">
            </p>
            <p>
                <input type="button" id="statusbutton" value="Change status">
            </p>
            <div id="conversations"></div>
            <script type="text/javascript" src="js/Chat.js"></script>
            <script type="text/javascript" src="js/FriendList.js"></script>
            <script type="text/javascript" src="js/ChangeStatus.js"></script>

        </c:when>
        <c:otherwise>
            <a href="Controller">Link to login</a>
        </c:otherwise>
    </c:choose>

</main>
<jsp:include page="footer.jsp">
    <jsp:param name="title" value="Chat"/>
</jsp:include>
</body>
</html>
