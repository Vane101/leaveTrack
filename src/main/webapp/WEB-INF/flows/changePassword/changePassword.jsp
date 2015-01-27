<%--
  Created by IntelliJ IDEA.
  User: vane
  Date: 2014/12/02
  Time: 08:58 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--@elvariable id="employeeSession" type="com.ubiquitech.leaveTrack.domain.Employee"--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html
        xmlns:c="http://java.sun.com/jsp/jstl/core"
        xmlns:jsp="http://java.sun.com/JSP/Page"
        xmlns:spring="http://www.springframework.org/tags"
        xmlns:form="http://www.springframework.org/tags/form">

<head>
    <title></title>
    <link href="<c:url value="/resources/theme/css/design.css"/>" rel="stylesheet"/>

</head>

<body>
<div class="applicationBody">

    <div class="heading">
        <p>&nbsp<span class="headingLeft">Change Password </span>
            <span class="headingRight">${employeeSession.firstName} ${employeeSession.lastName} (${employeeSession.username})</span>
        </p>
    </div>

    <div class="form">
        <form:form method="post" commandName="target" action="${flowExecutionUrl}">

            <table class="tableFields">
                <tr>
                    <td class="label">Enter your current password:</td>
                    <td><form:input path="oldPassword" size="35" type="password"/></td>
                    <td Class="error-message"><form:errors path="oldPassword"/></td>
                </tr>
                <tr>
                    <td class="label">Enter the new password:</td>
                    <td><form:input path="newPassword" size="35" type="password"/></td>
                    <td Class="error-message"><form:errors path="newPassword"/></td>
                </tr>
                <tr>
                    <td class="label">Enter the new password again:</td>
                    <td><form:input path="confirmNewPassword" size="35" type="password"/></td>
                    <td class="error-message"><form:errors path="confirmNewPassword"/></td>
                </tr>
            </table>

            <br/>
            &nbsp;&nbsp;&nbsp;&nbsp; <form:button type="submit" name="_eventId_cancel" class="cancel-btn">Cancel</form:button>
            &nbsp;&nbsp;&nbsp;&nbsp; <form:button type="submit" name="_eventId_save" class="save-btn">Save</form:button>
        </form:form>
        <%@ include file="/resources/theme/footer.jsp" %>
    </div>
</div>

</body>
</html>
