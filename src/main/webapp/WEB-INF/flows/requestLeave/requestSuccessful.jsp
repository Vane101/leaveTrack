<%--
  Created by IntelliJ IDEA.
  User: vane
  Date: 2014/12/10
  Time: 08:14 AM
  To change this template use File | Settings | File Templates.
--%>
<%--@elvariable id="employeeSession" type="com.ubiquitech.leaveTrack.domain.Employee"--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
        <p>&nbsp<span class="headingLeft">Request Leave</span>
            <span class="headingRight">${employeeSession.employeeName} (${employeeSession.username})</span>
        </p>
    </div>

    <div class="form">
        <div class="notification">
            <p>Leave request has been logged successfully</p>

            <P>The request has been sent to your supervisor for processing</p>

            <form action="home">
                <input type="submit" value="OK" class="ok-btn">
            </form>
        </div>
        <%@ include file="/resources/theme/footer.jsp" %>
    </div>
</div>
</body>
</html>