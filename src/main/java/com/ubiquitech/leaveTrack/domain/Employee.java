package com.ubiquitech.leaveTrack.domain;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * vane created on 2014/11/17.
 */
@Entity
@Table(name = "employee")
public class Employee implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "supervisorid")
    private Employee supervisor;

    @OneToMany(mappedBy = "supervisor")
    private Set<Employee> subordinates = new HashSet<Employee>();

    private String password;

    @OneToMany(mappedBy = "employee", cascade = {CascadeType.ALL})
    private Set<Request> request;

    @OneToOne(cascade = {CascadeType.ALL})//Parent Table
    @JoinColumn(name = "leaveId")//Column in parent table that joins with the child table column
    private LeaveDays leaveDays; //Child table class (DOMAIN)

    private boolean active = true;

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
        this.password = password.trim();
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle.toUpperCase().trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email.trim();
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber.trim();
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
        this.firstName = firstName.toUpperCase().trim();
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

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Request> getRequest() {
        return request;
    }

    public void setRequest(Set<Request> request) {
        this.request = request;
    }

    public Set<Employee> getSubordinates() {
        return subordinates;
    }

    public void setSubordinates(Set<Employee> subordinates) {
        this.subordinates = subordinates;
    }

    public Employee getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Employee supervisor) {
        this.supervisor = supervisor;
    }
}
