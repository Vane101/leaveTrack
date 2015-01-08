package com.ubiquitech.leaveTrack.form;

import com.ubiquitech.leaveTrack.domain.Request;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by vane on 2014/12/19.
 */
public class ProcessEmployeeLeaveForm implements Serializable {

    private static final long serialVersionUID = 1L;

    @Valid
    protected Request request = new Request();

    protected String employeeFullName;

    @NotEmpty
    protected Map<String, Object> map;

      public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(List nextState) {
        map = new HashMap<String, Object>();
        map.put("nextState",nextState);
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public String getEmployeeFullName() {
        return employeeFullName;
    }

    public void setEmployeeFullName(String employeeFullName) {
        this.employeeFullName = employeeFullName;
    }
}