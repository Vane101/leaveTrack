<%--
  Created by IntelliJ IDEA.
  User: vane
  Date: 2015/02/23
  Time: 04:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--@elvariable id="employeeSession" type="com.ubiquitech.leaveTrack.domain.Employee"--%>
<html>
<head>
    <title>Leave Track</title>
    <link href="<c:url value="/resources/theme/css/design.css"/>" rel="stylesheet"/>
    <style>

        td {
            font-size: 13px;
            color: black;
            width: 100px;
            height: 22px;
            text-align: center;
            background-color: white;
        }

        .heading {
            font-size: 18px;
            color: white;
            font: bold;
            background-color: #000099;
            border: thick;
        }
    </style>
</head>
<body>
<div class="tableBody">

    <div class="heading">
        <p>&nbsp<span class="headingLeft">Request Leave</span>
            <span class="headingRight">${employeeSession.employeeName} (${employeeSession.username})</span>
        </p>
    </div>

    <div class="form">

        <form:form method="post" commandName="target" action="${flowExecutionUrl}">
            <fieldset class="block">
                <legend>Employee Query Results</legend>
                <table class="tableFields" border="1" style="width:100%">
                    <tr>
                        <td class="heading">Action</td>
                        <td class="heading">Username</td>
                        <td class="heading">Employee name</td>
                        <td class="heading">Job Title</td>
                        <td class="heading">Supervisor Name</td>
                    </tr>
                        <%--@elvariable id="employeesFound" type="java.util.List"--%>
                    <c:forEach var="employees" items="${employeesFound}">
                        <tr>
                            <td>
                                <a href="${flowExecutionUrl}&_eventId=processEmployee&employeeId=${employees.id}">Employee Details</a>
                            </td>
                            <td>${employees.username}</td>
                            <td>${employees.employeeName}</td>
                            <td>${employees.jobTitle}</td>
                            <td>${employees.supervisor.employeeName}</td>
                        </tr>
                    </c:forEach>
                </table>
            </fieldset>
            <br/>
            &nbsp;&nbsp;&nbsp;&nbsp; <form:button type="submit" name="_eventId_back" class="back-btn" >Back</form:button>
            &nbsp;&nbsp;&nbsp;&nbsp; <form:button type="submit" name="_eventId_cancel" class="cancel-btn">Cancel</form:button>

        </form:form>
    </div>
</div>
</body>
</html>