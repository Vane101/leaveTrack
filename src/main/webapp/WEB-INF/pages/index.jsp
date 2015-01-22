<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page session="true" %>

<html lang="EN" xmlns:jsp="http://java.sun.com/JSP/Page">

<head>
    <title>leaveTrack</title>
    <link href="<c:url value="/resources/theme/css/design.css"/>" rel="stylesheet"/>
</head>
<body>
<c:url value="/j_spring_security_check" var="loginUrl"/>

<div class="applicationBody">

    <div class="heading">
        <p>Log in to LeaveTrack </p>
    </div>
    <div class="form">
        <p class="wrongPassword">&nbsp;&nbsp;&nbsp;&nbsp;${message}</p>

        <form action="${loginUrl}" method="post">
            <table>
                <tr>
                    <td><%--@declare id="username"--%><label for="username">Username:</label></td>
                    <td><label>
                        <input type="text" name="username" maxlength="25" size="16" required="required" value=""/>
                    </label></td>
                </tr>
                <tr>
                    <td><%--@declare id="password"--%><label for="password">password:</label></td>
                    <td><label>
                        <input type="password" name="password" required="required" maxlength="40" size="16" value=""/>
                    </label>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td>
                        <input type="submit" value="Login" name="submit"/></td>
                </tr>
            </table>
        </form>

        <p class="footer">&copy Ubiquitech 2006-2015</p>
    </div>
</div>
</body>
</html>