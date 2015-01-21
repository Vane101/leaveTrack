package com.ubiquitech.leaveTrack.form;

import com.ubiquitech.leaveTrack.domain.Employee;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

/**
 * Created by vane on 2014/12/02.
 */
public class ChangePasswordForm implements Serializable {
    public static final long serialVersionUID=1L;
    @NotEmpty
    protected String oldPassword;
    @NotEmpty
    protected String newPassword;
    @NotEmpty
    protected String confirmNewPassword;

    protected Employee employee=new Employee();

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getConfirmNewPassword() {
        return confirmNewPassword;
    }

    public void setConfirmNewPassword(String confirmNewPassword) {
        this.confirmNewPassword = confirmNewPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }
}
