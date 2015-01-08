<%--
  Created by IntelliJ IDEA.
  User: vane
  Date: 2014/12/08
  Time: 02:03 PM
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
        <p>&nbsp<span class="headingLeft">Request Leave</span>
            <span class="headingRight">${employeeSession.firstName} ${employeeSession.lastName} (${employeeSession.username})</span></p>
    </div>

    <div class="form">
        <form:form method="post" commandName="target" action="${flowExecutionUrl}">
            <fieldset class="block">
                <legend>Leave Request</legend>
                <table class="tableFieldsAlignLeft">
                    <tr>
                        <td class="label">Request Type:</td>
                        <td> <form:select path="request.leaveType">
                            <form:option value="" label="Select"/>
                            <form:options items="${target.map.leaveType}"/>
                        </form:select>
                        </td>
                        <td Class="error-message"><form:errors path="request.leaveType"/></td>
                    </tr>
                    <tr>
                        <td class="label">Start Date</td>
                        <td><form:input path="startDate" size="25" placeholder="CCYY/MM/DD"/></td>
                        <td  Class="error-message"> <form:errors path="startDate"/></td>
                    </tr>

                    <tr>
                        <td class="label">End Date</td>
                        <td><form:input path="endDate" size="25" placeholder="CCYY/MM/DD"/></td>
                        <td  Class="error-message"> <form:errors path="endDate"/></td>
                    </tr>
                    <tr>
                        <td class="label">Reason:</td>
                        <td> <form:textarea path="request.reason" rows="7" cols="50"/></td>
                        <td Class="error-message"><form:errors path="request.reason" /></td>
                    </tr>
                </table>
            </fieldset>
            <br/>
            &nbsp;&nbsp;&nbsp;&nbsp;  <form:button type="submit" name="_eventId_cancel">Cancel</form:button>
            &nbsp;&nbsp;&nbsp;&nbsp;  <form:button type="submit" name="_eventId_next">Next</form:button>
        </form:form>
          <%@ include file="/resources/theme/footer.jsp" %>
    </div>
</div>

</body>
</html>