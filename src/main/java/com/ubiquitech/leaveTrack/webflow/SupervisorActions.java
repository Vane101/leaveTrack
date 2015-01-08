package com.ubiquitech.leaveTrack.webflow;

import com.ubiquitech.leaveTrack.domain.Employee;
import com.ubiquitech.leaveTrack.domain.Request;
import com.ubiquitech.leaveTrack.form.ProcessEmployeeLeaveForm;
import com.ubiquitech.leaveTrack.services.EmployeeServiceImpl;
import com.ubiquitech.leaveTrack.services.RequestServiceImpl;
import org.springframework.webflow.action.MultiAction;
import org.springframework.webflow.core.collection.SharedAttributeMap;
import org.springframework.webflow.execution.Event;
import org.springframework.webflow.execution.RequestContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vane on 2014/12/11.
 */
public class SupervisorActions extends MultiAction {
    private RequestServiceImpl requestService;
    private EmployeeServiceImpl employeeService;
    private  List<Request> requestsInLoggedStatus;
    private   List<Request>  requestSelected;


    public Event getloggedRequests(RequestContext context,SharedAttributeMap map){
        Employee employee =(Employee)map.get("employeeSession");
        requestsInLoggedStatus =  requestService.getRequestsByStatusAndSupervisorId("Logged",employee.getId());
        context.getFlowScope().put("requestsLogged",requestsInLoggedStatus);
        return success();
    }

    public Event selectLeaveRequest(int requestId,ProcessEmployeeLeaveForm form){

        requestSelected =  requestService.getRequestsByStatusAndRequestId("Logged",(long)requestId);
        form.setRequest(requestSelected.get(0));
        //setting next state options
        List<String> nextState = new ArrayList<String>();
        nextState.add("Approve request");
        nextState.add("Reject request");
        form.setMap(nextState);
        form.setEmployeeFullName(form.getRequest().getEmployee().getFirstName()+" "+ form.getRequest().getEmployee().getLastName());
        return success();
    }

    public Event updateRequest(ProcessEmployeeLeaveForm form) {

        Request request = form.getRequest();
        requestService.createRequest(request);
        return success();
    }

    public void setEmployeeService(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    public void setRequestService(RequestServiceImpl requestService) {
        this.requestService = requestService;
    }
}
