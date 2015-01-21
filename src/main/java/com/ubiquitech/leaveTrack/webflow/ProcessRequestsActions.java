package com.ubiquitech.leaveTrack.webflow;

import com.ubiquitech.leaveTrack.services.EmployeeService;
import com.ubiquitech.leaveTrack.services.EmployeeServiceImpl;
import com.ubiquitech.leaveTrack.services.RequestService;
import com.ubiquitech.leaveTrack.services.RequestServiceImpl;
import org.springframework.webflow.action.MultiAction;

/**
 * Created by vane on 2014/12/10.
 */
public class ProcessRequestsActions extends MultiAction {
    private RequestService requestService;
    private EmployeeService employeeService;


    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    public void setRequestService(RequestService requestService) {
        this.requestService = requestService;
    }

}
