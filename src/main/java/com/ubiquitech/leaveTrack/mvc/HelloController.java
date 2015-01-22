package com.ubiquitech.leaveTrack.mvc;

import com.google.gson.Gson;
import com.ubiquitech.leaveTrack.calendar.FullCalendar;
import com.ubiquitech.leaveTrack.domain.Employee;
import com.ubiquitech.leaveTrack.domain.LeaveDays;
import com.ubiquitech.leaveTrack.domain.Request;
import com.ubiquitech.leaveTrack.services.EmployeeService;
import com.ubiquitech.leaveTrack.services.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@Controller
public class HelloController {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private RequestService requestService;

    private List<FullCalendar> fullCalendar = new ArrayList<FullCalendar>();

    private boolean calendarBoolean = true;

    @RequestMapping("/")
    public ModelAndView index() {
        return new ModelAndView("index");
    }

    @RequestMapping("/setupCalendar")
    public ModelAndView setupCalendar() {
        fullCalendar.clear();
        List<Request> requestsApproved;
        requestsApproved = requestService.getRequestsByState("Approved");

        Random rand = new Random();
        String randomColor = "";
        int myRandomNumber = 0;
        String title = "";
        String startDate = "";
        String endDate = "";

        if (calendarBoolean) {

            for (int i = 0; i < requestsApproved.size(); i++) {
                myRandomNumber = rand.nextInt(0x100000) + 0x100000;
                randomColor = Integer.toHexString(myRandomNumber);
                title = requestsApproved.get(i).getEmployee().getFirstName() + " " + requestsApproved.get(i).getEmployee().getLastName() + " " + requestsApproved.get(i).getLeaveType() + ".Request ID:" + requestsApproved.get(i).getId();
                startDate = String.valueOf(requestsApproved.get(i).getStartDate());
                endDate = String.valueOf(requestsApproved.get(i).getEndDate());
                FullCalendar fc = new FullCalendar("#" + randomColor, title, startDate, endDate);
                fullCalendar.add(fc);
            }
            calendarBoolean = false;
        }

        return new ModelAndView("/calendarView");

    }

    @RequestMapping("/calendarView")
    public ModelAndView calendar() {
        return new ModelAndView("calendarView");
    }


    @RequestMapping("calendar")
    public void calendar(@RequestParam(required = false) HttpServletRequest request, HttpServletResponse response) {

        // you might find it easier to use Jackson JSON mapper, which is supported by spring. You can return the object
        // that you want converted to JSON from the method, and spring will automatically convert it to JSON. You just
        // need to add a @ResponseBody annotation to the method.

        //Convert FullCalendar from Java to JSON
        Gson gson = new Gson();
        String jsonAppointment = gson.toJson(fullCalendar);

        //Printout the JSON
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        try {
            response.getWriter().write(jsonAppointment);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @RequestMapping("home")
    public ModelAndView menu(@ModelAttribute Employee employee) {
        calendarBoolean = true;
        return new ModelAndView("home");
    }

    @RequestMapping("index")
    public ModelAndView getLoginForm(
            @RequestParam(required = false) String authfailed, String logout, String denied, HttpServletRequest request) {

        String message = "";
        if (authfailed != null) {
            message = "Invalid username or password";
        } else if (logout != null) {
            HttpSession session = request.getSession();

            session.invalidate();
            message = "Logged Out successfully";
        } else if (denied != null) {
            message = "Access denied for this user !";
        }
        return new ModelAndView("index", "message", message);
    }

    @RequestMapping("menu")
    public String geUserPage() {
        return "menu";
    }

    @Scope("request")
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