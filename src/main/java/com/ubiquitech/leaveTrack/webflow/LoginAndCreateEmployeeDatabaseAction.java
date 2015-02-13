package com.ubiquitech.leaveTrack.webflow;

import com.ubiquitech.leaveTrack.domain.Employee;
import com.ubiquitech.leaveTrack.form.CreateEmployeeForm;
import com.ubiquitech.leaveTrack.hash.HashPassword;
import com.ubiquitech.leaveTrack.services.EmployeeService;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.webflow.action.EventFactorySupport;
import org.springframework.webflow.action.MultiAction;
import org.springframework.webflow.execution.Event;
import org.springframework.webflow.execution.RequestContext;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

/**
 * vane created on 2014/11/20.
 */
public class LoginAndCreateEmployeeDatabaseAction extends MultiAction {

    final DateTimeFormatter dateFormat = DateTimeFormat.forPattern("yyyy/MM/dd");
    private EmployeeService employeeService;

    public Event setupSupervisorOptions(CreateEmployeeForm form) {//Set Supervisor options to be displayed on dropdown list
        List<String> nameList = new ArrayList<String>();
        List<Object[]> employees = employeeService.getEmployeeNames();//Gets all employee names
        nameList.add("SELECT");
        for (Object[] employee : employees) {
            String name = employee[1] + " " + employee[2];
            nameList.add(name);
        }
        form.setMap(nameList);
        return success();
    }

    public Event setSupervisorName(CreateEmployeeForm form, MessageContext messageContext) { //set supervisor ID based on name selected
        List map = (List) form.getMap().get("name");
        if (form.getSupervisorID() > 0) {
            form.setSupervisorName((String) map.get(form.getSupervisorID()));
            form.getEmployee().setSupervisor(employeeService.getEmployeeById((long) form.getSupervisorID()));
        } else {
            form.setSupervisorName("");
        }

        if (form.getSupervisorID() == 0) {
            form.getEmployee().setSupervisor(null);
        }

        boolean found = employeeService.checkUsername(form.getEmployee().getUsername());

        if (found) {
            MessageBuilder errorMessageBuilder = new MessageBuilder().error();
            errorMessageBuilder.source("employee.username");
            errorMessageBuilder.code("userExists");
            messageContext.addMessage(errorMessageBuilder.build());
            return new EventFactorySupport().error(this);
        } else {
            return success();
        }
    }

    public Event hashPassword(CreateEmployeeForm form) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        HashPassword hashPassword = new HashPassword();
        String password = form.getPassword();
        String hashedPass = hashPassword.hash(password);
        form.getEmployee().setPassword(hashedPass);
        return success();
    }

    public Event confirmDetails(RequestContext content, MessageContext messageContext) {

        Event event = null;
        CreateEmployeeForm form = (CreateEmployeeForm) content.getFlowScope().get("target");
        String userPassword = form.getPassword();
        String confirmPassword = form.getConfirmPassword();
        String phoneNumber = form.getEmployee().getPhoneNumber();
        String email = form.getEmployee().getEmail();

        if (phoneNumber.matches("[2][7]\\d{9}")) {
        } else {
            MessageBuilder errorMessageBuilder = new MessageBuilder().error();
            errorMessageBuilder.source("employee.phoneNumber");
            errorMessageBuilder.code("wrongPhoneNumberFormat");
            messageContext.addMessage(errorMessageBuilder.build());
            return new EventFactorySupport().error(this);
        }

        String emailPattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";


        if (email.matches(emailPattern)) {
        } else {
            MessageBuilder errorMessageBuilder = new MessageBuilder().error();
            errorMessageBuilder.source("employee.email");
            errorMessageBuilder.code("wrongEmailFormat");
            messageContext.addMessage(errorMessageBuilder.build());
            return new EventFactorySupport().error(this);
        }

        try {
            form.getEmployee().getLeaveDays().setYearEmployed(dateFormat.parseLocalDate(form.getDateEmployed()));
        } catch (Exception e) {
            MessageBuilder errorMessageBuilder = new MessageBuilder().error();
            errorMessageBuilder.source("dateEmployed");
            errorMessageBuilder.code("wrongDateFormat");
            messageContext.addMessage(errorMessageBuilder.build());
            return new EventFactorySupport().error(this);
        }

        if (userPassword.equals(confirmPassword)) {
            return success();
        } else {
            MessageBuilder errorMessageBuilder = new MessageBuilder().error();
            errorMessageBuilder.source("confirmPassword");
            errorMessageBuilder.code("passwordMisMatch");
            messageContext.addMessage(errorMessageBuilder.build());
            return new EventFactorySupport().error(this);
        }

    }

    public Event createEmployee(RequestContext content) {
        Event event = null;
        CreateEmployeeForm form = (CreateEmployeeForm) content.getFlowScope().get("target");
        Employee employee = form.getEmployee();
        if ((employee != null)) {
            employeeService.createEmployee(employee);
            event = success();
        } else {
            event = error();
        }

        return event;
    }

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
}
