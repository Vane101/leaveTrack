<%--
  Created by IntelliJ IDEA.
  User: vane
  Date: 2015/01/20
  Time: 02:33 PM
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
        <p>&nbsp<span class="headingLeft">Request Query</span>
            <span class="headingRight">${employeeSession.firstName} ${employeeSession.lastName} (${employeeSession.username})</span>
        </p>
    </div>

    <div class="form">
        <form:form method="post" commandName="target" action="${flowExecutionUrl}">
            <fieldset class="block">
                <legend>Search for requests</legend>
                <table class="tableFields">
                    <tr>
                        <td class="label">Employee firstname:</td>
                        <td><form:input path="employeeFirstName" size="25"/></td>
                        <td class="label">Employee surname:</td>
                        <td><form:input path="employeeLastName" size="25"/></td>
                    </tr>
                    <tr>
                        <td class="label">Supervisor firstname:</td>
                        <td><form:input path="supervisorFirstName" size="25"/></td>
                        <td class="label">Supervisor surname:</td>
                        <td><form:input path="supervisorLastName" size="25"/></td>
                    </tr>

                    <tr>
                        <td class="label">Request ID:</td>
                        <td><form:input path="requestId" size="25"/></td>
                    </tr>

                    <tr>
                        <td class="label">State</td>
                        <td Class="droplist">
                            <form:select path="state">
                                <form:option value="" label="Select"/>
                                <form:options items="${target.map.stateList}"/>
                            </form:select>
                        </td>
                    </tr>

                    <tr>
                        <td class="label">Leave type</td>
                        <td Class="droplist">
                            <form:select path="leaveType">
                                <form:option value="" label="Select"/>
                                <form:options items="${target.map.leaveTypeList}"/>
                            </form:select>
                        </td>
                    </tr>

                </table>
            </fieldset>
            <br/>
            &nbsp;&nbsp;&nbsp;&nbsp; <form:button type="submit" name="_eventId_cancel" class="cancel-btn">Cancel</form:button>
            &nbsp;&nbsp;&nbsp;&nbsp; <form:button type="submit" name="_eventId_search" class="ok-btn">Next</form:button>
        </form:form>
        <%@ include file="/resources/theme/footer.jsp" %>
    </div>
</div>

</body>
</html>