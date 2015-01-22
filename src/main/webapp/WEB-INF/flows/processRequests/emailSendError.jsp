<%--
  Created by IntelliJ IDEA.
  User: vane
  Date: 2015/01/09
  Time: 02:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page session="true" %>
<html lang="EN" xmlns:jsp="http://java.sun.com/JSP/Page">

<head>
    <title>leaveTrack</title>
    <link href="<c:url value="/resources/theme/css/design.css"/>" rel="stylesheet"/>
</head>
<body>
<div class="applicationBody">

    <div class="heading">
        <p>&nbsp<span class="headingLeft">Process Leave Request</span>
            <span class="headingRight">${employeeSession.firstName} ${employeeSession.lastName} (${employeeSession.username})</span>
        </p>
    </div>

    <div class="form">
        <div class="notification">
            <p>The Application has been processed successfully</p>

            <p>However an email could not be sent to the employee</p>

            <form action="home">
                <input type="submit" value="OK">
            </form>
        </div>
        <%@ include file="/resources/theme/footer.jsp" %>
    </div>
</div>
</body>
</html>