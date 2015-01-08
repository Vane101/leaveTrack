package com.ubiquitech.leaveTrack.domain;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by vane on 2014/11/17.
 */
@Entity
@Table(name="employee")
public class Employee  implements Serializable{
    private static final long serialVersionUID=1L;

    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Version
    private int version;

    @NotEmpty
    private String username;
    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;

    private String phoneNumber;
    @NotEmpty
    private String email;
    private String jobTitle;

    @Column(name="supervisorid")
    private Integer supervisorId;
    private String password;

    @OneToMany(mappedBy="employee",cascade = {CascadeType.ALL})
    private Set<Request> request;

    @OneToOne(cascade ={CascadeType.ALL})//Parent Table
    @JoinColumn(name="leaveId")//Column in parent table that joins with the child table column
    private LeaveDays leaveDays; //Child table class (DOMAIN)

    private boolean active =true;

    public Employee() {
        this.leaveDays = new LeaveDays();
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public LeaveDays getLeaveDays() {
        return leaveDays;
    }

    public void setLeaveDays(LeaveDays leaveDays) {
        this.leaveDays = leaveDays;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getSupervisorId() {
        return supervisorId;
    }

    public void setSupervisorId(Integer supervisorId) {
        this.supervisorId = supervisorId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username.toUpperCase().trim();
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public Long getId() {
        return id;
    }

    public Set<Request> getRequest() {
        return request;
    }

    public void setRequest(Set<Request> request) {
        this.request = request;
    }
}
