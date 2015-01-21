package com.ubiquitech.leaveTrack.webflow;

import com.ubiquitech.leaveTrack.domain.Request;
import com.ubiquitech.leaveTrack.form.RequestQueryForm;
import com.ubiquitech.leaveTrack.services.EmployeeServiceImpl;
import com.ubiquitech.leaveTrack.services.RequestServiceImpl;
import org.springframework.webflow.action.MultiAction;
import org.springframework.webflow.execution.Event;
import org.springframework.webflow.execution.RequestContext;

import java.util.List;

/**
 * Created by vane on 2015/01/20.
 */
public class RequestQueryActions extends MultiAction {
    private RequestServiceImpl requestService;
    private EmployeeServiceImpl employeeService;
    private List<Request> requestsFound;
    private   List<Request>  requestSelected;

    public Event getRequests(RequestContext context){

        RequestQueryForm form=(RequestQueryForm) context.getFlowScope().get("target");
        requestsFound=requestService.getQueriedRequests(form);
        context.getFlowScope().put("requestsFound", requestsFound);
        return success();
    }

    public Event selectLeaveRequest(int requestId,RequestQueryForm form){

        requestSelected = requestService.getRequestsByStatusAndRequestId("",(long)requestId);
        form.setRequest(requestSelected.get(0));
        form.setEmployeeFullName(form.getRequest().getEmployee().getFirstName()+" "+ form.getRequest().getEmployee().getLastName());
        form.setSupervisorFullName(form.getRequest().getEmployee().getSupervisor().getFirstName()+" "+form.getRequest().getEmployee().getSupervisor().getLastName());
        return success();
    }

    public void setEmployeeService(EmployeeServiceImpl employeeService) {
            this.employeeService = employeeService;
        }

        public void setRequestService(RequestServiceImpl requestService) {
            this.requestService = requestService;
        }

}
