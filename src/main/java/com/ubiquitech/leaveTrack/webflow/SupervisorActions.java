package com.ubiquitech.leaveTrack.webflow;

import com.ubiquitech.leaveTrack.constants.AppConstants;
import com.ubiquitech.leaveTrack.domain.Employee;
import com.ubiquitech.leaveTrack.domain.Request;
import com.ubiquitech.leaveTrack.eMail.Mail;
import com.ubiquitech.leaveTrack.form.ProcessEmployeeLeaveForm;
import com.ubiquitech.leaveTrack.services.EmployeeService;
import com.ubiquitech.leaveTrack.services.RequestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.webflow.action.MultiAction;
import org.springframework.webflow.core.collection.SharedAttributeMap;
import org.springframework.webflow.execution.Event;
import org.springframework.webflow.execution.RequestContext;

import java.util.List;

/**
 * vane created on 2014/12/11.
 */
public class SupervisorActions extends MultiAction {
    final Logger logger = LoggerFactory.getLogger(RequestLeaveActions.class);
    private RequestService requestService;
    private EmployeeService employeeService;
    @Autowired
    private Mail mail;

    public Event getLoggedRequests(RequestContext context, SharedAttributeMap map) {
        Employee employee = (Employee) map.get("employeeSession");
        List requestsInLoggedStatus = requestService.getRequestsByStatusAndSupervisorId(AppConstants.requestStateEnum.LOGGED.toString(), employee.getId());
        context.getFlowScope().put("requestsLogged", requestsInLoggedStatus);
        return success();
    }

    public Event selectLeaveRequest(int requestId, ProcessEmployeeLeaveForm form) {

        List requestSelected = requestService.getRequestsByStatusAndRequestId(AppConstants.requestStateEnum.LOGGED.toString(), (long) requestId);
        form.setRequest((Request) requestSelected.get(0));
        form.setEmployeeFullName(form.getRequest().getEmployee().getFirstName() + " " + form.getRequest().getEmployee().getLastName());
        return success();
    }

    public Event updateRequest(ProcessEmployeeLeaveForm form) {
        Request request = form.getRequest();
        requestService.createRequest(request);
        return success();
    }

    public Event sendEmplyeeEmail(ProcessEmployeeLeaveForm form, SharedAttributeMap map) {
        Employee employee = (Employee) map.get("employeeSession");
        String employeeEmail = form.getRequest().getEmployee().getEmail();
         try {
            mail.sendMail(
                /*FROM:*/ employee.getEmail(),
                  /*TO:*/ employeeEmail,
             /*SUBJECT:*/  "Leave Request",
             /*MESSAGE:*/  "==========This is an automatically generated Email, Please do not reply.==========\n" + employee.getFirstName() + " " + employee.getLastName()
                    + " has " + form.getRequest().getState() + " your leave request, Please log into LeaveTrack for more details");
            return success();
        } catch (Exception e) {
            logger.error("Email could not be sent");
            logger.debug("Debug message", e);
            return error();
        }
    }


    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public void setRequestService(RequestService requestService) {
        this.requestService = requestService;
    }
}
