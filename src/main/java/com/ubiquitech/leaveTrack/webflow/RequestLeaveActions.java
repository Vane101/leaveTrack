package com.ubiquitech.leaveTrack.webflow;

import com.ubiquitech.leaveTrack.domain.Employee;
import com.ubiquitech.leaveTrack.domain.Request;
import com.ubiquitech.leaveTrack.eMail.Mail;
import com.ubiquitech.leaveTrack.form.RequestLeaveForm;
import com.ubiquitech.leaveTrack.services.EmployeeServiceImpl;
import com.ubiquitech.leaveTrack.services.RequestServiceImpl;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.webflow.action.EventFactorySupport;
import org.springframework.webflow.action.MultiAction;
import org.springframework.webflow.core.collection.SharedAttributeMap;
import org.springframework.webflow.execution.Event;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vane on 2014/12/08.
 */
public class RequestLeaveActions extends MultiAction {
      private RequestServiceImpl requestService;
      private EmployeeServiceImpl employeeService;
      final DateTimeFormatter dateFormat = DateTimeFormat.forPattern("yyyy/MM/dd");
      final Logger logger = LoggerFactory.getLogger(RequestLeaveActions.class);
    @Autowired
    private Mail mail;

    public Event setupSupervisorOptions(RequestLeaveForm form){
        form.getRequest().setComment("");
        form.getRequest().setState("Logged");
        List<String> leaveTypes = new ArrayList<String>();
        leaveTypes.add("Annual Leave");
        leaveTypes.add("Sick Leave");
        leaveTypes.add("Maternity Leave");
        leaveTypes.add("Family Leave");
        form.setMap(leaveTypes);
        return success();
    }

    public Event confirmDetails(RequestLeaveForm form, MessageContext messageContext) {

        Event event = null;
        try {
            form.getRequest().setStartDate(dateFormat.parseLocalDate(form.getStartDate()));
        }catch (Exception e){
            MessageBuilder errorMessageBuilder= new MessageBuilder().error();
            errorMessageBuilder.source("startDate");
            errorMessageBuilder.code("wrongDateFormat");
            messageContext.addMessage(errorMessageBuilder.build());
            return new EventFactorySupport().error(this);
        }

        try {
            form.getRequest().setEndDate(dateFormat.parseLocalDate(form.getEndDate()));
            return success();
        }catch (Exception e){
            MessageBuilder errorMessageBuilder= new MessageBuilder().error();
            errorMessageBuilder.source("endDate");
            errorMessageBuilder.code("wrongDateFormat");
            messageContext.addMessage(errorMessageBuilder.build());
            return new EventFactorySupport().error(this);
        }
    }

    public Event apply(RequestLeaveForm form, SharedAttributeMap map) {
       Employee employee =(Employee)map.get("employeeSession");
        Request request = form.getRequest();
        request.setSupervisorId(employee.getSupervisor().getId());
        request.setEmployee(employee);
        requestService.createRequest(request);
        return success();
    }

    public Event sendSupervisorEmail(RequestLeaveForm form,SharedAttributeMap map) {
        Employee employee =(Employee)map.get("employeeSession");
        String supervisorEmail= employee.getSupervisor().getEmail();
       try {
           mail.sendMail(
                /*FROM:*/ employee.getEmail(),
                  /*TO:*/ supervisorEmail,
             /*SUBJECT:*/  "Leave Request",
             /*MESSAGE:*/  "==========This is an automatically generated Email, Please do not reply.==========\n" + employee.getFirstName() + " " + employee.getLastName()
                   + " has applied for leave, please log into leaveTrack to process this request.");
            return success();
       }catch (Exception e){
           logger.error("Email could not be sent");
           logger.debug("Debug message",e);
           return error();
       }


    }

    public void setEmployeeService(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    public void setRequestService(RequestServiceImpl requestService) {
        this.requestService = requestService;
    }
}
