<%--
  Created by IntelliJ IDEA.
  User: vane
  Date: 2015/01/16
  Time: 10:27 AM
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
    <link href="<c:url value="/resources/fullCalendar/fullcalendar.css"/>" rel="stylesheet"/>
    <link href="<c:url value="/resources/fullCalendar/fullcalendar.print.css"/>" rel="stylesheet" media="print"/>
    <link href="<c:url value="/resources/theme/css/design.css"/>" rel="stylesheet"/>
    <script src="<c:url value="/resources/fullCalendar/moment.min.js"/>"></script>
    <script src="<c:url value="/resources/fullCalendar/jquery.min.js"/>"></script>
    <script src="<c:url value="/resources/fullCalendar/fullcalendar.js"/>"></script>

    <style>
        #calendar{font-size:14px !important;}
    </style>
    <script>

        $(document).ready(function () {

            var calendar = $('#calendar').fullCalendar({
                header: {
                    left: 'prev,next today',
                    center: 'title',
                    right: 'month,agendaWeek,agendaDay'
                },

                eventClick: function (calEvent, jsEvent, view) {
                          $.get("test",{id:calEvent.id},
                            function(data,status){
                                                          window.location="calendarEventDetails"
                            });

              },

                select: function (start, end, color,allDay,id) {
                    var title = prompt('Event Title:');
                    if (title) {
                        calendar.fullCalendar('renderEvent',
                                {
                                    title: title,
                                    start: start,
                                    end: end,
                                    color: color,
                                    allDay: allDay,
                                    id:id,
                                    className: 'fc-event-width-overirde'
                                },
                                true // make the event "stick"

                        );
                    }
                    calendar.fullCalendar('unselect');
                },

                editable: true,

                eventSources: [
                    {
                        url: 'calendar',
                        type: 'GET',
                        data: {
                            start: 'start',
                            end: 'end',
                            title: 'title',
                            color: 'color',
                            allDay: 'allDay',
                            id:'id',
                            className: 'fc-event-width-overirde'
                        },
                        error: function () {
                            alert('there was an error while fetching events!');
                        }
                    }
                ]
            });

        });
    </script>
</head>
<body>

<div class="calendarApplicationBody">

    <div class="heading">
        <p>&nbsp<span class="headingLeft">Calendar</span>
            <span class="headingRight">${employeeSession.firstName} ${employeeSession.lastName} (${employeeSession.username})</span>
        </p>
    </div>

    <div class="form">
        <div id="calendar"></div>
        <form action="home">
            <input type="submit" value="Cancel" class="cancel-btn">
        </form>
        <%@ include file="/resources/theme/footer.jsp" %>

    </div>
</div>

</body>
</html>