<%--@elvariable id="employeeSession" type="com.ubiquitech.leaveTrack.domain.Employee"--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="EN" xmlns:jsp="http://java.sun.com/JSP/Page">

<head>
    <title>leaveTrack</title>
    <link href="<c:url value="/resources/theme/css/homePage.css"/>" rel="stylesheet"/>
    <link href="<c:url value="/resources/theme/css/design.css"/>" rel="stylesheet"/>
    <script src="<c:url value="/resources/fullCalendar/moment.min.js"/>"></script>
    <script src="<c:url value="/resources/fullCalendar/jquery.min.js"/>"></script>
    <meta charset='utf-8'>
    <link rel="stylesheet" href="styles.css">
    <script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
    <script>
        ( function( $ ) {
            $( document ).ready(function() {
                $('#cssmenu ul ul li:odd').addClass('odd');
                $('#cssmenu ul ul li:even').addClass('even');
                $('#cssmenu > ul > li > a').click(function() {
                    $('#cssmenu li').removeClass('active');
                    $(this).closest('li').addClass('active');
                    var checkElement = $(this).next();
                    if((checkElement.is('ul')) && (checkElement.is(':visible'))) {
                        $(this).closest('li').removeClass('active');
                        checkElement.slideUp('normal');
                    }
                    if((checkElement.is('ul')) && (!checkElement.is(':visible'))) {
                        $('#cssmenu ul ul:visible').slideUp('normal');
                        checkElement.slideDown('normal');
                    }
                    if($(this).closest('li').find('ul').children().length == 0) {
                        return true;
                    } else {
                        return false;
                    }
                });
            });
        } )( jQuery );

    </script>
    <title>Leave Track</title>
</head>
<body>
<c:url value="/j_spring_security_logout" var="logoutUrl"/>
<div class="applicationBody">
    <div class="heading">
        <p>&nbsp<span class="headingLeft">LeaveTrack Main Menu </span>
            <span class="headingRight">${employeeSession.employeeName} (${employeeSession.username})</span>
        </p>
    </div>

    <div class="form">
        <div class="Tasks">
            <div id='cssmenu'>
                <ul>
                    <li class='active'><a href='#'><span>Home</span></a></li>
                    <li class='has-sub'><a href='#'><span>Employee</span></a>
                        <ul>
                           <li><a href='<c:url value="/editEmployee"/>'><span>Edit Details</span></a></li>
                            <li><a href='<c:url value="/createEmployee"/>'><span>Create Employee</span></a></li>
                            <li class='last'><a href='<c:url value="/changePassword"/>'><span>Change password</span></a></li>
                        </ul>
                    </li>
                    <li class='has-sub'><a href='#'><span>Leave Request</span></a>
                        <ul>
                            <li><a href='<c:url value="/requestLeave"/>'><span>Request Leave</span></a></li>
                            <li class='last'><a href='<c:url value="/processRequests"/>'><span>Process Requests</span></a></li>
                        </ul>
                    </li>

                    <li class='has-sub'><a href='#'><span>leaveTrack Query</span></a>
                        <ul>
                            <li><a href='<c:url value="/queryRequest"/>'><span> Requests Query</span></a></li>
                            <li><a href='<c:url value="/queryEmployee"/>'><span>Employee Query</span></a></li>
                            <li class='last'><a href='<c:url value="setupCalendar"/>'><span>Calendar View</span></a></li>
                        </ul>
                    </li>

                    <li class='has-sub'><a href='#'><span>Logout</span></a>
                        <ul>
                            <li class='last'><a href="${logoutUrl}"><span>Log off</span></a></li>
                        </ul>
                    </li>

                    </ul>
            </div>
        </div>
        <%@ include file="/resources/theme/footer.jsp" %>
    </div>
</div>

</body>
</html>