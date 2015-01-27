<%--
  Created by IntelliJ IDEA.
  User: vane
  Date: 2014/12/18
  Time: 07:33 PM
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
        <p>&nbsp<span class="headingLeft">Process Leave Request</span>
            <span class="headingRight">${employeeSession.firstName} ${employeeSession.lastName} (${employeeSession.username})</span>
        </p>
    </div>

    <div class="form">
        <form:form method="post" commandName="target" action="${flowExecutionUrl}">
            <fieldset class="block">
                <legend>Process leave request</legend>
                <table class="tableFieldsAlignLeft">

                    <tr>
                        <td class="label">Employee name</td>
                        <td><input type="text" value="${target.employeeFullName}" readonly class="readOnlyText"></td>
                    </tr>

                    <tr>
                        <td class="label">Leave type</td>
                        <td><input type="text" value="${target.request.leaveType}" readonly class="readOnlyText"></td>
                    </tr>

                    <tr>
                        <td class="label">Start Date</td>
                        <td><input type="text" value="${target.request.startDate}" readonly class="readOnlyText"></td>
                    </tr>

                    <tr>
                        <td class="label">End Date</td>
                        <td><input type="text" value="${target.request.endDate}" readonly class="readOnlyText"></td>
                    </tr>

                    <tr>
                        <td class="label">Reason:</td>
                        <td><label>
                            <textarea rows="7" cols="50" readonly
                                      class="readOnlyText">${target.request.reason}</textarea>
                        </label></td>
                    </tr>

                    <tr>
                        <td class="label">Next Status</td>
                        <td><form:select path="request.state">
                            <form:option value="" label="Select"/>
                            <form:options items="${target.map.nextState}"/>
                        </form:select></td>
                        <td Class="error-message"><form:errors path="request.state"/></td>
                    </tr>

                    <tr>
                        <td class="label">Comment:</td>
                        <td><form:textarea path="request.comment" rows="7" cols="50"/></td>
                        <td Class="error-message"><form:errors path="request.comment"/></td>
                    </tr>

                </table>
            </fieldset>
            <br/>
            &nbsp;&nbsp;&nbsp;&nbsp; <form:button type="submit" name="_eventId_back" class="back-btn">Back</form:button>
            &nbsp;&nbsp;&nbsp;&nbsp; <form:button type="submit" name="_eventId_save" class="save-btn">Save</form:button>
            &nbsp;&nbsp;&nbsp;&nbsp; <form:button type="submit" name="_eventId_cancel" class="cancel-btn">Cancel</form:button>
        </form:form>
        <%@ include file="/resources/theme/footer.jsp" %>
    </div>
</div>

</body>
</html>
