package com.ubiquitech.leaveTrack.webflow;

import com.ubiquitech.leaveTrack.constants.AppConstants;
import com.ubiquitech.leaveTrack.domain.Employee;
import com.ubiquitech.leaveTrack.domain.Request;
import com.ubiquitech.leaveTrack.eMail.Mail;
import com.ubiquitech.leaveTrack.form.RequestLeaveForm;
import com.ubiquitech.leaveTrack.services.EmployeeService;
import com.ubiquitech.leaveTrack.services.RequestService;
import org.joda.time.LocalDate;
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

/**
 * vane created on 2014/12/08.
 */
public class RequestLeaveActions extends MultiAction {
    final DateTimeFormatter dateFormat = DateTimeFormat.forPattern("yyyy/MM/dd");
    final Logger logger = LoggerFactory.getLogger(RequestLeaveActions.class);
    private RequestService requestService;
    private EmployeeService employeeService;
    @Autowired
    private Mail mail;

    public Event setupSupervisorOptions(RequestLeaveForm form) {
        form.getRequest().setComment("LOGGED");
        form.getRequest().setState(AppConstants.requestStateEnum.LOGGED.toString());
        return success();
    }

    public Event confirmDetails(RequestLeaveForm form, MessageContext messageContext) {

        LocalDate startDate;
        LocalDate endDate;
        Event event = null;
        try {
            startDate=dateFormat.parseLocalDate(form.getStartDate());
            form.getRequest().setStartDate(startDate);
        } catch (Exception e) {
            MessageBuilder errorMessageBuilder = new MessageBuilder().error();
            errorMessageBuilder.source("startDate");
            errorMessageBuilder.code("wrongDateFormat");
            messageContext.addMessage(errorMessageBuilder.build());
            return new EventFactorySupport().error(this);
        }

        try {
            endDate=dateFormat.parseLocalDate(form.getEndDate());
            form.getRequest().setEndDate(endDate);

        } catch (Exception e) {
            MessageBuilder errorMessageBuilder = new MessageBuilder().error();
            errorMessageBuilder.source("endDate");
            errorMessageBuilder.code("wrongDateFormat");
            messageContext.addMessage(errorMessageBuilder.build());
            return new EventFactorySupport().error(this);
        }

          if(endDate.isAfter(startDate)){
            return success();
        }else{
            MessageBuilder errorMessageBuilder = new MessageBuilder().error();
            errorMessageBuilder.source("endDate");
            errorMessageBuilder.code("invalidEndDate");
            messageContext.addMessage(errorMessageBuilder.build());
            return new EventFactorySupport().error(this);
        }
    }

    public Event apply(RequestLeaveForm form, SharedAttributeMap map) {
        Employee employee = (Employee) map.get("employeeSession");
        Request request = form.getRequest();

        request.setEmployee(employee);
        requestService.createRequest(request);
        return success();
    }

    public Event sendSupervisorEmail(RequestLeaveForm form, SharedAttributeMap map) {
        Employee employee = (Employee) map.get("employeeSession");
        String supervisorEmail = employee.getSupervisor().getEmail();
        try {
            mail.sendMail(
                /*FROM:*/ employee.getEmail(),
                  /*TO:*/ supervisorEmail,
             /*SUBJECT:*/  "Leave Request",
             /*MESSAGE:*/  "==========This is an automatically generated Email, Please do not reply.==========\n" + employee.getEmployeeName()
                    + " has applied for leave, please log into leaveTrack to process this request.");
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
