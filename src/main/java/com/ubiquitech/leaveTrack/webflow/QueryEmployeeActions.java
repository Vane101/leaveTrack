package com.ubiquitech.leaveTrack.webflow;

import com.ubiquitech.leaveTrack.domain.Request;
import com.ubiquitech.leaveTrack.form.QueryEmployeeForm;
import com.ubiquitech.leaveTrack.services.EmployeeService;
import com.ubiquitech.leaveTrack.services.RequestService;
import org.springframework.webflow.action.MultiAction;
import org.springframework.webflow.execution.Event;
import org.springframework.webflow.execution.RequestContext;

import java.util.List;

/**
 * vane created on 2015/02/23.
 */
public class QueryEmployeeActions extends MultiAction {
    private RequestService requestService;
    private EmployeeService employeeService;

    public Event getEmployees(RequestContext context) {
        QueryEmployeeForm form = (QueryEmployeeForm) context.getFlowScope().get("target");
        List employeesFound = employeeService.getQueriedEmployees(form);
        context.getFlowScope().put("employeesFound", employeesFound);
        return success();
    }

    public Event selectEmployee(int employeeId, QueryEmployeeForm form) {
        form.setEmployee(employeeService.getEmployeeById((long)employeeId));
        return success();
    }

    public Event getEmployeeRequests(int employeeId,RequestContext context) {
        List employeesRequestsFound = requestService.getRequestByEmployeeId((long)employeeId);
        context.getFlowScope().put("employeesRequestsFound", employeesRequestsFound);
        return success();
    }

    public Event selectLeaveRequest(int requestId, QueryEmployeeForm form) {
        List requestSelected = requestService.getRequestsByStatusAndRequestId("", (long) requestId);
        form.setRequest((Request) requestSelected.get(0));
        return success();
    }

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public void setRequestService(RequestService requestService) {
        this.requestService = requestService;
    }

}