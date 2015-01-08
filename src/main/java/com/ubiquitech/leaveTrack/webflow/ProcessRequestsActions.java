package com.ubiquitech.leaveTrack.webflow;

import com.ubiquitech.leaveTrack.services.EmployeeServiceImpl;
import com.ubiquitech.leaveTrack.services.RequestServiceImpl;
import org.springframework.webflow.action.MultiAction;

/**
 * Created by vane on 2014/12/10.
 */
public class ProcessRequestsActions extends MultiAction {
    private RequestServiceImpl requestService;
    private EmployeeServiceImpl employeeService;


    public void setEmployeeService(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }
    public void setRequestService(RequestServiceImpl requestService) {
        this.requestService = requestService;
    }

}
