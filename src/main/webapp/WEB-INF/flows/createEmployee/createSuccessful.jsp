<%--@elvariable id="_csrf" type="org.springframework.security.web.csrf.DefaultCsrfToken"--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--@elvariable id="employeeSession" type="com.ubiquitech.leaveTrack.domain.Employee"--%>
<%--
  Created by IntelliJ IDEA.
  User: vane
  Date: 2014/11/20
  Time: 03:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="EN" xmlns:jsp="http://java.sun.com/JSP/Page">

<head>
    <title>leaveTrack</title>
    <link href="<c:url value="/resources/theme/css/design.css"/>" rel="stylesheet"/>
</head>
<body>
<c:url value="/j_spring_security_logout" var="logoutUrl"/>
<div class="applicationBody">

    <div class="heading">
        <p>&nbsp<span class="headingLeft">Create New Employee</span>
            <span class="headingRight">${employeeSession.firstName} ${employeeSession.lastName} (${employeeSession.username})</span>
        </p>
    </div>

    <div class="form">
        <div class="notification">
            <p>Employee successfully created </p>
            <form action="home">
                <input type="submit" value="OK" class="ok-btn">
            </form>
        </div>
        <%@ include file="/resources/theme/footer.jsp" %>
    </div>
</div>
</body>
</html>

