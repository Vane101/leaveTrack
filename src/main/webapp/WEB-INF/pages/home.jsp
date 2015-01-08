<%--@elvariable id="employeeSession" type="com.ubiquitech.leaveTrack.domain.Employee"--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="EN" xmlns:jsp="http://java.sun.com/JSP/Page" >

        <head>
            <title>leaveTrack</title>
            <link href="<c:url value="/resources/theme/css/design.css"/>" rel="stylesheet"/>
        </head>
        <body>
        <c:url value="/j_spring_security_logout" var="logoutUrl" />
            <div class="applicationBody">
                    <div class="heading">
                       <p>&nbsp<span class="headingLeft">LeaveTrack Main Menu </span>
                        <span class="headingRight">${employeeSession.firstName} ${employeeSession.lastName} (${employeeSession.username})</span></p>
                    </div>

                    <div class="form">
                         <div class="Tasks">
                            <a href="${logoutUrl}">Logout</a><br><br>
                            <a href='<c:url value="/createEmployee"/>'><span>Create employee</span></a> <br> <br>
                            <a href='<c:url value="/changePassword"/>'><span>Change password</span></a> <br> <br>
                            <a href='<c:url value="/editEmployee"/>'><span>Edit Details</span></a> <br> <br>
                            <a href='<c:url value="/requestLeave"/>'><span>Request Leave</span></a> <br> <br>
                            <a href='<c:url value="/processRequests"/>'><span>Process Requests</span></a> <br> <br>
                          </div>
                        <%@ include file="/resources/theme/footer.jsp" %>
                     </div>
             </div>

          </body>
</html>