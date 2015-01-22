<%--
  Created by IntelliJ IDEA.
  User: vane
  Date: 2014/12/19
  Time: 04:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%--@elvariable id="employeeSession" type="com.ubiquitech.leaveTrack.domain.Employee"--%>
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

            <p>An email has been sent to the employee</p>

            <form action="home">
                <input type="submit" value="OK">
            </form>
        </div>
        <%@ include file="/resources/theme/footer.jsp" %>
    </div>
</div>
</body>
</html>