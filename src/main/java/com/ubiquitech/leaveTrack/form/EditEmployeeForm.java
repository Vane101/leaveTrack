package com.ubiquitech.leaveTrack.form;

import com.ubiquitech.leaveTrack.domain.Employee;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by vane on 2014/12/04.
 */
public class EditEmployeeForm implements Serializable{
    private static final long serialVersionUID=1L;

    protected Map<String,Object> map;

    protected String supervisorName;

    @Valid
    protected Employee employee=new Employee();

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(List nameList) {
        map = new HashMap<String, Object>();
        map.put("name",nameList);
    }

    public String getSupervisorName() {
        return supervisorName;
    }

    public void setSupervisorName(String supervisorName) {
        this.supervisorName = supervisorName;
    }

}