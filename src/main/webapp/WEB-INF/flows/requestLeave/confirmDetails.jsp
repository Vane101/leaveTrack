<%--
  Created by IntelliJ IDEA.
  User: vane
  Date: 2014/12/08
  Time: 03:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%--@elvariable id="employeeSession" type="com.ubiquitech.leaveTrack.domain.Employee"--%>
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
            <span class="headingRight">${employeeSession.employeeName} (${employeeSession.username})</span>
        </p>
    </div>

    <div class="form">
        <div class="notification">
            <p> Please verify the following data is correct. Press
                the "Back" button to make any necessary changes.</p>
        </div>

        <form:form method="post" commandName="target" action="${flowExecutionUrl}">
            <fieldset class="block">
                <legend>Confirm Details</legend>
                <table>
                    <tr>
                        <td class="label">Request Type:</td>
                        <td><label>
                            <input type="text" value="${target.request.leaveType}" readonly class="readOnlyText">
                        </label></td>
                    </tr>
                    <tr>
                        <td class="label">Start date</td>
                        <td><label>
                            <input type="text" value="${target.startDate}" readonly class="readOnlyText">
                        </label></td>
                    </tr>
                    <tr>
                        <td class="label">End Date:</td>
                        <td><label>
                            <input type="text" value="${target.endDate}" readonly class="readOnlyText">
                        </label></td>
                    </tr>
                    <tr>
                        <td class="label">Reason:</td>
                        <td><label>
                            <textarea rows="7" cols="50" readonly
                                      class="readOnlyText">${target.request.reason}</textarea>
                        </label></td>
                    </tr>

                </table>
            </fieldset>
            <br/>
            &nbsp;&nbsp;&nbsp;&nbsp; <form:button type="submit" name="_eventId_back" class="back-btn">Back</form:button>
            &nbsp;&nbsp;&nbsp;&nbsp; <form:button type="submit" name="_eventId_confirm" class="confirm-btn">Confirm</form:button>
        </form:form>
        <%@ include file="/resources/theme/footer.jsp" %>
    </div>
</div>

</body>
</html>