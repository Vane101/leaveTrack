<%--
  Created by IntelliJ IDEA.
  User: vane
  Date: 2014/11/20
  Time: 02:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%--@elvariable id="employeeSession" type="com.ubiquitech.leaveTrack.domain.Employee"--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <link rel="stylesheet" href="//code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css">
    <script src="//code.jquery.com/jquery-1.10.2.js"></script>
    <script src="//code.jquery.com/ui/1.11.2/jquery-ui.js"></script>
    <script>
        $(function () {
            $("#Date").datepicker({dateFormat: 'yy/mm/dd'});
        });

    </script>
</head>

<body>
<div class="applicationBody">

    <div class="heading">
        <p>&nbsp<span class="headingLeft">Create New Employee </span>
            <span class="headingRight">${employeeSession.firstName} ${employeeSession.lastName} (${employeeSession.username})</span>
        </p>
    </div>

    <div class="form">
        <form:form method="post" commandName="target" action="${flowExecutionUrl}">
            <fieldset class="block">
                <legend>Employee details</legend>
                <table class="tableFields">
                    <tr>
                        <td class="label">Username:</td>
                        <td><form:input path="employee.username" size="25"/></td>
                        <td Class="error-message"><form:errors path="employee.username"/></td>
                    </tr>
                    <tr>
                        <td class="label">First name:</td>
                        <td><form:input path="employee.firstName" size="25"/></td>
                        <td Class="error-message"><form:errors path="employee.firstName"/></td>
                    </tr>
                    <tr>
                        <td class="label">Last name:</td>
                        <td><form:input path="employee.lastName" size="25"/></td>
                        <td class="error-message"><form:errors path="employee.lastName"/></td>
                    </tr>
                    <tr>
                        <td class="label">Phone number:</td>
                        <td><form:input path="employee.phoneNumber" size="25" placeholder="27"/></td>
                        <td Class="error-message"><form:errors path="employee.phoneNumber"/></td>
                    </tr>
                    <tr>
                        <td class="label">email:</td>
                        <td><form:input path="employee.email" size="25"/></td>
                        <td Class="error-message"><form:errors path="employee.email"/></td>
                    </tr>
                    <tr>
                        <td class="label">Job title:</td>
                        <td><form:input path="employee.jobTitle" size="25"/></td>
                    </tr>
                    <tr>
                        <td class="label">Supervisor</td>
                        <td Class="droplist">
                            <form:select path="supervisorID">
                                <c:forEach items="${target.map.name}" var="supervisorID" varStatus="loopStatus">
                                    <form:option value="${loopStatus.index}">${supervisorID}</form:option>
                                </c:forEach>
                            </form:select>
                        </td>
                    </tr>
                    <tr>
                        <td class="label">Date employed:</td>
                        <td><form:input id="Date" path="dateEmployed" size="25" placeholder="CCYY/MM/DD"/></td>
                        <td Class="error-message"><form:errors path="dateEmployed"/></td>
                    </tr>
                    <tr>
                        <td class="label">Password:</td>
                        <td><form:input path="password" type="password" size="25"/></td>
                        <td Class="error-message"><form:errors path="password"/></td>
                    </tr>
                    <tr>
                        <td class="label">Confirm password:</td>
                        <td><form:input path="confirmPassword" type="password" size="25"/></td>
                        <td Class="error-message"><form:errors path="confirmPassword"/></td>
                    </tr>
                </table>
            </fieldset>
            <br/>
            &nbsp;&nbsp;&nbsp;&nbsp; <form:button type="submit" name="_eventId_cancel" class="cancel-btn">Cancel</form:button>
            &nbsp;&nbsp;&nbsp;&nbsp; <form:button type="submit" name="_eventId_next" class="ok-btn">Next</form:button>
        </form:form>
        <%@ include file="/resources/theme/footer.jsp" %>
    </div>
</div>

</body>
</html>
