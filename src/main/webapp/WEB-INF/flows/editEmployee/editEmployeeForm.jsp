<%--
  Created by IntelliJ IDEA.
  User: vane
  Date: 2014/12/04
  Time: 11:39 AM
  To change this template use File | Settings | File Templates.
--%>
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
        <p>&nbsp<span class="headingLeft">Edit Employee </span>
            <span class="headingRight">${employeeSession.employeeName} (${employeeSession.username})</span>
        </p>
    </div>

    <div class="form">
        <form:form method="post" commandName="target" action="${flowExecutionUrl}">

            <fieldset class="block">
                <legend>Edit employee details</legend>
                <table class="tableFields">
                    <tr>
                        <td class="label">Employee name:</td>
                        <td><form:input path="employee.employeeName" size="25"/></td>
                        <td Class="error-message"><form:errors path="employee.employeeName"/></td>
                    </tr>
                    <tr>
                        <td class="label">Phone number</td>
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
                </table>
            </fieldset>
            <br/>
            &nbsp;&nbsp;&nbsp;&nbsp; <form:button type="submit" name="_eventId_cancel" class="cancel-btn" >Cancel</form:button>
            &nbsp;&nbsp;&nbsp;&nbsp; <form:button type="submit" name="_eventId_next" class="next-btn" id="confirm">Next</form:button>
            <script type="text/javascript">
                PAGE.register(['simpleAccordion', 'springJQuery', 'keyboard', 'ui', 'jqueryui'], function (simpleAccordion, springJQuery, keyboard, ui) {
                    simpleAccordion.init('#mainMenu', {cookieName: 'mainMenu'});

                    var dialogContent = $('#localLoginRecordsDialog').detach().show();
                    if (dialogContent.size() != 0) {
                        ui.toModalDialog(dialogContent.html(), {title: 'Recent Login Attempts'});
                    }
                    springJQuery.addAjaxLinkHandler('#confirm', {modal: true, dialogOpts: {title: 'Recent Login Attempts'}});
                    springJQuery.addAjaxLinkHandler('#changeAdminUnit', {modal: true, dialogOpts: {title: 'Change to another Admin Unit'}});

                    $(document).bind('keydown', 'right', function () {
                        $('.globalTasks a').first().focus();
                    });
                    $(document).bind('keydown', 'left', function () {
                        $('#mainMenu').find('a').first().focus();
                    });
                    keyboard.navigableList($('.globalTasks'));
                });
            </script>




        </form:form>
        <%@ include file="/resources/theme/footer.jsp" %>
    </div>
</div>

</body>
</html>