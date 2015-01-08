package com.ubiquitech.leaveTrack.webflow;

import com.ubiquitech.leaveTrack.domain.Employee;
import com.ubiquitech.leaveTrack.form.EditEmployeeForm;
import com.ubiquitech.leaveTrack.services.EmployeeServiceImpl;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.webflow.action.EventFactorySupport;
import org.springframework.webflow.action.MultiAction;
import org.springframework.webflow.core.collection.SharedAttributeMap;
import org.springframework.webflow.execution.Event;
import org.springframework.webflow.execution.RequestContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vane on 2014/12/04.
 */
public class EditEmployeeDatabaseAction  extends MultiAction{
    private EmployeeServiceImpl employeeService;

    public Event setupFormObject(EditEmployeeForm form, SharedAttributeMap map) {

        Employee newEmployee =(Employee)map.get("employeeSession");
        form.setEmployee(newEmployee);

        List<String> nameList = new ArrayList<String>();
        List<Object[]> employees =employeeService.getEmployeeNames();
        nameList.add("Select");
        for(Object[] employee:employees){
            String name = employee[1]+" "+ employee[2];
            nameList.add(name);
        }
        form.setMap(nameList);

        return success();
    }

    public Event setSupervisorName (EditEmployeeForm form, MessageContext messageContext ){
        List map= (List) form.getMap().get("name");
        if(form.getEmployee().getSupervisorId()>0) {
            form.setSupervisorName((String)map.get(form.getEmployee().getSupervisorId()));
        } else{
            form.setSupervisorName("");
        }

        if(form.getEmployee().getSupervisorId()==0){
            form.getEmployee().setSupervisorId(null);
        }

        return success();

    }

    public Event confirmDetails(RequestContext content, MessageContext messageContext) {

        Event event = null;
        EditEmployeeForm form = (EditEmployeeForm) content.getFlowScope().get("target");

        String phoneNumber=form.getEmployee().getPhoneNumber();
        String email=form.getEmployee().getEmail();



        String emailPattern="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";


        if(email.matches(emailPattern)){
        }else {
            MessageBuilder errorMessageBuilder= new MessageBuilder().error();
            errorMessageBuilder.source("employee.email");
            errorMessageBuilder.code("wrongEmailFormat");
            messageContext.addMessage(errorMessageBuilder.build());
            return new EventFactorySupport().error(this);
        }

        if (phoneNumber.matches("[2][7]\\d{9}")){
            return success();
        }else{
            MessageBuilder errorMessageBuilder= new MessageBuilder().error();
            errorMessageBuilder.source("employee.phoneNumber");
            errorMessageBuilder.code("wrongPhoneNumberFormat");
            messageContext.addMessage(errorMessageBuilder.build());
            return new EventFactorySupport().error(this);
        }

    }

    public Event createEmployee(RequestContext content) {
        Event event = null;
        EditEmployeeForm form = (EditEmployeeForm) content.getFlowScope().get("target");
        Employee employee = form.getEmployee();
        if ((employee != null)) {
            employeeService.createEmployee(employee);
            event = success();
        } else {
            event = error();
        }

        return event;
    }


    public void setEmployeeService(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }
}
