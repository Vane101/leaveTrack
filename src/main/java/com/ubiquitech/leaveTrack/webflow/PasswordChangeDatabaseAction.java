package com.ubiquitech.leaveTrack.webflow;

import com.ubiquitech.leaveTrack.domain.Employee;
import com.ubiquitech.leaveTrack.form.ChangePasswordForm;
import com.ubiquitech.leaveTrack.hash.HashPassword;
import com.ubiquitech.leaveTrack.services.EmployeeService;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.webflow.action.EventFactorySupport;
import org.springframework.webflow.action.MultiAction;
import org.springframework.webflow.core.collection.SharedAttributeMap;
import org.springframework.webflow.execution.Event;
import org.springframework.webflow.execution.RequestContext;

/**
 * vane created on 2014/12/02.
 */
public class PasswordChangeDatabaseAction extends MultiAction {
    private EmployeeService employeeService;

    public Event confirmDetails(RequestContext context, MessageContext messageContext, SharedAttributeMap map) {

        ChangePasswordForm form = (ChangePasswordForm) context.getFlowScope().get("target");
        HashPassword hashPassword = new HashPassword();

        Employee employee = (Employee) map.get("employeeSession");
        form.setEmployee(employee);

        if (BCrypt.checkpw(form.getOldPassword(), employee.getPassword())) {
        } else {
            MessageBuilder errorMessageBuilder = new MessageBuilder().error();
            errorMessageBuilder.source("oldPassword");
            errorMessageBuilder.code("passwordInvalid");
            messageContext.addMessage(errorMessageBuilder.build());
            return new EventFactorySupport().error(this);
        }

        if (form.getNewPassword().equals(form.getConfirmNewPassword())) {
            employee.setPassword(hashPassword.hash(form.getNewPassword()));
            employeeService.createEmployee(employee);
            return success();
        } else {
            MessageBuilder errorMessageBuilder = new MessageBuilder().error();
            errorMessageBuilder.source("confirmNewPassword");
            errorMessageBuilder.code("passwordMisMatch");
            messageContext.addMessage(errorMessageBuilder.build());
            return new EventFactorySupport().error(this);
        }
    }


    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
}
