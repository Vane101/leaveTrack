<%--
  Created by IntelliJ IDEA.
  User: vane
  Date: 2015/01/20
  Time: 06:02 PM
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
        <p>&nbsp<span class="headingLeft">Query Requests</span>
            <span class="headingRight">${employeeSession.firstName} ${employeeSession.lastName} (${employeeSession.username})</span></p>
    </div>

    <div class="form">
        <form:form method="post" commandName="target" action="${flowExecutionUrl}">
            <fieldset class="block">
                <legend>Request Details</legend>
                <table class="tableFieldsAlignLeft">

                    <tr>
                        <td class="label">Employee name</td>
                        <td><input type="text" value="${target.employeeFullName}" readonly class="readOnlyText"> </td>
                    </tr>

                    <tr>
                        <td class="label">Supervisor name</td>
                        <td><input type="text" value="${target.supervisorFullName}" readonly class="readOnlyText"> </td>
                    </tr>

                    <tr>
                        <td class="label">Leave type</td>
                        <td><input type="text" value="${target.request.leaveType}" readonly class="readOnlyText"> </td>
                    </tr>

                    <tr>
                        <td class="label">Start Date</td>
                        <td><input type="text" value="${target.request.startDate}" readonly class="readOnlyText"> </td>
                    </tr>

                    <tr>
                        <td class="label">End Date</td>
                        <td><input type="text" value="${target.request.endDate}" readonly class="readOnlyText"> </td>
                    </tr>

                    <tr>
                        <td class="label">Reason:</td>
                        <td><label>
                            <textarea rows="7" cols="50" readonly class="readOnlyText">${target.request.reason}</textarea>
                        </label></td>
                    </tr>

                    <tr>
                        <td class="label">Status</td>
                        <td><input type="text" value="${target.request.state}" readonly class="readOnlyText"> </td>
                      </tr>

                    <tr>
                        <td class="label">Supervisor comment:</td>
                        <td><label>
                            <textarea rows="7" cols="50" readonly class="readOnlyText">${target.request.comment}</textarea>
                        </label></td>
                    </tr>
                </table>
            </fieldset>
            <br/>
            &nbsp;&nbsp;&nbsp;&nbsp;  <form:button type="submit" name="_eventId_back">Back</form:button>
            &nbsp;&nbsp;&nbsp;&nbsp;  <form:button type="submit" name="_eventId_cancel">Cancel</form:button>
        </form:form>
        <%@ include file="/resources/theme/footer.jsp" %>
    </div>
</div>

</body>
</html>
