<%--
  Created by IntelliJ IDEA.
  User: vane
  Date: 2015/01/20
  Time: 06:02 PM
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
        <p>&nbsp<span class="headingLeft">Query Requests</span>
            <span class="headingRight">${employeeSession.firstName} ${employeeSession.lastName} (${employeeSession.username})</span>
        </p>
    </div>

    <div class="form">
        <form action=""><%--@elvariable id="calendarRequest" type="com.ubiquitech.leaveTrack.form.QueryRequestForm"--%>
            <fieldset class="block">
                <legend>Request Details</legend>
                <table class="tableFieldsAlignLeft">

                    <tr>
                        <td class="label">Employee name</td>
                        <td><label>
                            <input type="text" value="${calendarRequest.employeeFullName}" readonly class="readOnlyText">
                        </label></td>
                    </tr>

                    <tr>
                        <td class="label">Supervisor name</td>
                        <td><label>
                            <input type="text" value="${calendarRequest.supervisorFullName}" readonly class="readOnlyText">
                        </label></td>
                    </tr>

                    <tr>
                        <td class="label">Leave type</td>
                        <td><label>
                            <input type="text" value="${calendarRequest.request.leaveType}" readonly class="readOnlyText">
                        </label></td>
                    </tr>

                    <tr>
                        <td class="label">Start Date</td>
                        <td><label>
                            <input type="text" value="${calendarRequest.request.startDate}" readonly class="readOnlyText">
                        </label></td>
                    </tr>

                    <tr>
                        <td class="label">End Date</td>
                        <td><label>
                            <input type="text" value="${calendarRequest.request.endDate}" readonly class="readOnlyText">
                        </label></td>
                    </tr>

                    <tr>
                        <td class="label">Reason:</td>
                        <td><label>
                            <textarea rows="7" cols="50" readonly
                                      class="readOnlyText">${calendarRequest.request.reason}</textarea>
                        </label></td>
                    </tr>

                    <tr>
                        <td class="label">Status</td>
                        <td><label>
                            <input type="text" value="${calendarRequest.request.state}" readonly class="readOnlyText">
                        </label></td>
                    </tr>

                    <tr>
                        <td class="label">Supervisor comment:</td>
                        <td><label>
                            <textarea rows="7" cols="50" readonly
                                      class="readOnlyText">${calendarRequest.request.comment}</textarea>
                        </label></td>
                    </tr>
                </table>
            </fieldset>
            <br/>
        </form>

        &nbsp;&nbsp;&nbsp;&nbsp;  <form action="setupCalendar"><input type="submit" value="Back" class="back-btn"></form>
        &nbsp;&nbsp;&nbsp;&nbsp;  <form action="home"><input type="submit" value="Cancel"  class="cancel-btn"></form>

        <%@ include file="/resources/theme/footer.jsp" %>
    </div>
</div>

</body>
</html>
