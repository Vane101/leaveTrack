<%--
  Created by IntelliJ IDEA.
  User: vane
  Date: 2015/01/20
  Time: 04:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Leave Track</title>
    <style>

        body {
            font-size: 20px;
            color: black;
        }

        td {
            font-size: 15px;
            color: black;
            width: 100px;
            height: 22px;
            text-align: center;
        }
        .heading {
            font-size: 18px;
            color: white;
            font: bold;
            background-color: steelblue;
            border: thick;
        }
    </style>
</head>
<body>
<center>

    <form:form method="post" commandName="target" action="${flowExecutionUrl}">
        <fieldset class="block">
            <legend>Leave Requests</legend>
            <table class="tableFields" border="1" style="width:100%">
                <tr>
                    <td class="heading">Action</td>
                    <td class="heading">Employee name</td>
                    <td class="heading">Time</td>
                    <td class="heading">leave Type</td>
                    <td class="heading">Reason</td>
                    <td class="heading">Start Date</td>
                    <td class="heading">End Date</td>
                    <td class="heading">Status</td>
                </tr>
             
                <%--@elvariable id="requestsFound" type="java.util.List"--%>
                <c:forEach var="requests" items="${requestsFound}">
                    <tr>
                        <td>
                            <a href="${flowExecutionUrl}&_eventId=processRequest&requestId=${requests.id}">Details</a>
                        </td>

                        <td>${requests.employee.firstName} ${requests.employee.lastName}</td>
                        <td>${requests.timestamp}</td>
                        <td>${requests.leaveType}</td>
                        <td>${requests.reason}</td>
                        <td>${requests.startDate}</td>
                        <td>${requests.endDate}</td>
                        <td>${requests.state}</td>
                    </tr>
                </c:forEach>

            </table>
        </fieldset>
        <br/>
        &nbsp;&nbsp;&nbsp;&nbsp;  <form:button type="submit" name="_eventId_back">Back</form:button>
        &nbsp;&nbsp;&nbsp;&nbsp;  <form:button type="submit" name="_eventId_cancel">Cancel</form:button>

    </form:form>

</center>
</body>
</html>