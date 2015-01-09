package com.ubiquitech.leaveTrack.mvc;

import com.ubiquitech.leaveTrack.domain.Employee;
import com.ubiquitech.leaveTrack.domain.LeaveDays;
import com.ubiquitech.leaveTrack.services.EmployeeServiceImpl;
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
import javax.servlet.http.HttpSession;

@Controller
public class HelloController {
      @Autowired
      private EmployeeServiceImpl employeeService;

 @RequestMapping("/")
	public ModelAndView index() {
		return new ModelAndView("index");
	}

    @RequestMapping ("home")
    public ModelAndView menu(@ModelAttribute Employee employee){
        return new ModelAndView("home");
    }

   @RequestMapping("index")
    public ModelAndView getLoginForm(
            @RequestParam(required = false) String authfailed, String logout,String denied,HttpServletRequest request) {

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
        String username=auth.getName();
        Employee employee;
        LeaveDays leaveDays;

       try {
            employee = employeeService.getEmployee(username.toUpperCase());
            HttpSession session=request.getSession(true);
            session.setAttribute("employeeSession",employee);
             }catch (Exception e){
           e.printStackTrace();
        }

          return new ModelAndView("home");

    }

}