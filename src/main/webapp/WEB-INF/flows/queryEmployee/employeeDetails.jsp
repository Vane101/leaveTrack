<%--
  Created by IntelliJ IDEA.
  User: vane
  Date: 2015/02/26
  Time: 06:32 PM
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
</head>

<body>
<div class="applicationBody">

    <div class="heading">
        <p>&nbsp<span class="headingLeft">Employee Query</span>
            <span class="headingRight">${employeeSession.employeeName} (${employeeSession.username})</span>
        </p>
    </div>

    <div class="form">
        <form:form method="post" commandName="target" action="${flowExecutionUrl}">
            <fieldset class="block">
                <legend>Employee Details</legend>
                <table class="tableFieldsAlignLeft">
                    <tr>
                        <td class="label">Username</td>
                        <td><label>
                            <input type="text" value="${target.employee.username}" readonly class="readOnlyText">
                        </label></td>
                    </tr>

                    <tr>
                        <td class="label">Employee name</td>
                        <td><label>
                            <input type="text" value="${target.employee.employeeName}" readonly class="readOnlyText">
                        </label></td>
                    </tr>

                    <tr>
                        <td class="label">Supervisor name</td>
                        <td><label>
                            <input type="text" value="${target.employee.supervisor.employeeName}" readonly class="readOnlyText">
                        </label></td>
                    </tr>

                    <tr>
                        <td class="label">Phone number</td>
                        <td><label>
                            <input type="text" value="${target.employee.phoneNumber}" readonly class="readOnlyText">
                        </label></td>
                    </tr>

                    <tr>
                        <td class="label">Email</td>
                        <td><label>
                            <input type="text" value="${target.employee.email}" readonly class="readOnlyText">
                        </label></td>
                    </tr>

                    <tr>
                        <td class="label">Job title</td>
                        <td><label>
                            <input type="text" value="${target.employee.jobTitle}" readonly class="readOnlyText">
                        </label></td>
                    </tr>

                    <tr>
                        <td class="label">Date employed</td>
                        <td><label>
                            <input type="text" value="${target.employee.leaveDays.yearEmployed}" readonly class="readOnlyText">
                        </label></td>
                    </tr>

                    <tr>
                        <td></td>
                        <td></td>
                        <td class="history-link"><a href="${flowExecutionUrl}&_eventId=getEmployeeRequests&employeeId=${target.employee.id}">View Leave History</a></td>
                    </tr>
                </table>

            </fieldset>
            <br/>
            &nbsp;&nbsp;&nbsp;&nbsp; <form:button type="submit" name="_eventId_back" class="back-btn">Back</form:button>
            &nbsp;&nbsp;&nbsp;&nbsp; <form:button type="submit" name="_eventId_cancel" class="cancel-btn">Cancel</form:button>
        </form:form>
        <%@ include file="/resources/theme/footer.jsp"%>
    </div>
</div>