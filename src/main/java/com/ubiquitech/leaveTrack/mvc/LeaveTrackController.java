package com.ubiquitech.leaveTrack.mvc;

import com.ubiquitech.leaveTrack.calendar.FullCalendar;
import com.ubiquitech.leaveTrack.domain.Employee;
import com.ubiquitech.leaveTrack.domain.LeaveDays;
import com.ubiquitech.leaveTrack.domain.Request;
import com.ubiquitech.leaveTrack.form.QueryRequestForm;
import com.ubiquitech.leaveTrack.services.EmployeeService;
import com.ubiquitech.leaveTrack.services.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@Controller
public class LeaveTrackController {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private RequestService requestService;

    private boolean calendarBoolean = true;


    @RequestMapping(value = "eventDetails")
    public ModelAndView setupEventDetails(@RequestParam("id") long id, HttpServletRequest request) {
        QueryRequestForm calendarRequest = new QueryRequestForm();
        calendarRequest.setRequest((Request) requestService.getRequestsByStatusAndRequestId("Approved", id).get(0));
        calendarRequest.setEmployeeName(calendarRequest.getRequest().getEmployee().getEmployeeName());
        calendarRequest.setSupervisorName(calendarRequest.getRequest().getEmployee().getSupervisor().getEmployeeName());
        HttpSession session = request.getSession(true);
        session.setAttribute("calendarRequest", calendarRequest);
        return new ModelAndView("requestDetails");
    }


    @RequestMapping(value = "calendarEventDetails", method = RequestMethod.GET)
    public ModelAndView calendarEventDetails() {
        calendarBoolean = true;
        return new ModelAndView("requestDetails");
    }

    @RequestMapping("/")
    public ModelAndView index() {
        return new ModelAndView("index");
    }

    @RequestMapping("setupCalendar")
    public ModelAndView setupCalendar(HttpServletRequest request) {
        List<FullCalendar> fullCalendar = new ArrayList<FullCalendar>();
        List<Request> requestsApproved;
        requestsApproved = requestService.getRequestsByState("Approved");

        Random rand = new Random();
        String randomColor = "";
        int myRandomNumber = 0;
        String title = "";
        String startDate = "";
        String endDate = "";
        if (calendarBoolean) {

            for (Request aRequestsApproved : requestsApproved) {
                myRandomNumber = rand.nextInt(0x100000) + 0x100000;///Get a random Hex number to obtain a unique color for each event on calendar display
                randomColor = Integer.toHexString(myRandomNumber);
                title = aRequestsApproved.getEmployee().getEmployeeName()+ " " + aRequestsApproved.getLeaveType() + ".Request ID:" + aRequestsApproved.getId();
                startDate = String.valueOf(aRequestsApproved.getStartDate());
                endDate = String.valueOf(aRequestsApproved.getEndDate());
                long id = aRequestsApproved.getId();
                FullCalendar fc = new FullCalendar("#" + randomColor, title, startDate, endDate, id);
                fullCalendar.add(fc);
            }
            HttpSession session = request.getSession(true);
            session.setAttribute("calendarEvents", fullCalendar);
            calendarBoolean = false;
        }

        return new ModelAndView("/calendarView");
    }

    @RequestMapping("/calendarView")
    public ModelAndView calendar() {
        return new ModelAndView("calendarView");
    }

    @RequestMapping("calendar")
    public
    @ResponseBody
    List<FullCalendar> getFullCalendar(HttpSession session) {
        List<FullCalendar> fullCalendar = (List<FullCalendar>) session.getAttribute("calendarEvents");
        return fullCalendar;

    }

    @RequestMapping("home")
    public ModelAndView menu(@ModelAttribute Employee employee) {
        calendarBoolean = true;
        return new ModelAndView("home");
    }

    @RequestMapping("index")
    public ModelAndView getLoginForm(
            @RequestParam(required = false) String authfailed, String logout, String denied,String sessionTimeout, HttpServletRequest request) {

        String message = "";
        if (authfailed != null) {
            message = "Invalid username or password";
        } else if (logout != null) {
            HttpSession session = request.getSession();
            session.invalidate();
            message = "Logged Out successfully";

        } else if (sessionTimeout != null) {
            message = "Your session has expired, please log in again";

        } else if (denied != null) {
            message = "Access denied for this user!";
        }
        return new ModelAndView("index", "message", message);
    }

    @RequestMapping("menu")
    public String geUserPage() {
        return "menu";
    }


     @RequestMapping("/login")
    public ModelAndView checkDetails(HttpServletRequest request) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        Employee employee;
        LeaveDays leaveDays;

        try {
            employee = employeeService.getEmployee(username.toUpperCase());
            HttpSession session = request.getSession(true);
            session.setAttribute("employeeSession", employee);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ModelAndView("home");
    }

}