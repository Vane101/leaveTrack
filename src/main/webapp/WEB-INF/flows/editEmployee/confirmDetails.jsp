<%--
  Created by IntelliJ IDEA.
  User: vane
  Date: 2014/12/04
  Time: 11:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%--
  Created by IntelliJ IDEA.
  User: vane
  Date: 2014/11/20
  Time: 02:15 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
        <p>&nbsp<span class="headingLeft">Edit Employee </span>
            <span class="headingRight">${employeeSession.firstName} ${employeeSession.lastName} (${employeeSession.username})</span></p>
    </div>

    <div class="form">
        <div class="notification">
            <p> Please verify the following data is correct.  Press
                the "Back" button to make any necessary changes.</p>
        </div>

        <form:form method="post" commandName="target" action="${flowExecutionUrl}">
            <fieldset class="block">
                <legend>Confirm Details</legend>
                <table>
                    <tr>
                        <td class="label">First name:</td>
                        <td><label>
                            <input type="text" value="${target.employee.firstName}" readonly class="readOnlyText">
                        </label></td>
                    </tr>
                    <tr>
                        <td class="label">Last name:</td>
                        <td><label>
                            <input type="text" value="${target.employee.lastName}" readonly class="readOnlyText">
                        </label></td>
                    </tr>
                    <tr>
                        <td class="label">Phone Number:</td>
                        <td><label>
                            <input type="text" value="${target.employee.phoneNumber}" readonly class="readOnlyText">
                        </label></td>
                    </tr>
                    <tr>
                        <td class="label">Email:</td>
                        <td><label>
                            <input type="text" value="${target.employee.email}" readonly class="readOnlyText">
                        </label></td>
                    </tr>
                    <tr>
                        <td class="label">Job Title:</td>
                        <td><label>
                            <input type="text" value="${target.employee.jobTitle}" readonly class="readOnlyText">
                        </label></td>
                    </tr>
                    <tr>
                        <td class="label">Supervisor:</td>
                        <td><label>
                            <input type="text" value="${target.supervisorName}" readonly class="readOnlyText">
                        </label></td>
                    </tr>
                </table>
            </fieldset>
            <br/>
            &nbsp;&nbsp;&nbsp;&nbsp;  <form:button type="submit" name="_eventId_back">Back</form:button>
            &nbsp;&nbsp;&nbsp;&nbsp;  <form:button type="submit" name="_eventId_confirm">Confirm</form:button>
        </form:form>
        <%@ include file="/resources/theme/footer.jsp" %>
    </div>
</div>

</body>
</html>