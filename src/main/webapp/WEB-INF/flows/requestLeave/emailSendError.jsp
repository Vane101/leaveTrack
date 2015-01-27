<%--
  Created by IntelliJ IDEA.
  User: vane
  Date: 2015/01/09
  Time: 02:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page session="true" %>
<%--@elvariable id="employeeSession" type="com.ubiquitech.leaveTrack.domain.Employee"--%>
<html lang="EN" xmlns:jsp="http://java.sun.com/JSP/Page">

<head>
    <title>leaveTrack</title>
    <link href="<c:url value="/resources/theme/css/design.css"/>" rel="stylesheet"/>
</head>
<body>
<div class="applicationBody">

    <div class="heading">
        <p>&nbsp<span class="headingLeft">Request Leave</span>
            <span class="headingRight">${employeeSession.firstName} ${employeeSession.lastName} (${employeeSession.username})</span>
        </p>
    </div>

    <div class="form">
        <div class="notification">
            <p>Leave request has been logged successfully</p>

            <P>However an email could not be sent to your supervisor due to technical difficulties</p>

            <form action="home">
                <input type="submit" value="OK" class="ok-btn">
            </form>
        </div>
        <%@ include file="/resources/theme/footer.jsp" %>
    </div>
</div>
</body>
</html>