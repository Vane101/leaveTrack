package com.ubiquitech.leaveTrack.form;

import com.ubiquitech.leaveTrack.domain.Employee;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by vane on 2014/11/20.
 */
public class CreateEmployeeForm implements Serializable{
    private static final long serialVersionUID=1L;

    protected Map<String,Object> map;
    @NotEmpty
    protected String confirmPassword;

    protected String supervisorName;

    @Valid
    protected Employee employee=new Employee();

    protected String dateEmployed;

    @NotEmpty
    protected String password;

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDateEmployed() {
        return dateEmployed;
    }

    public void setDateEmployed(String dateEmployed) {
        this.dateEmployed = dateEmployed;
    }
}
