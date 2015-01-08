package com.ubiquitech.leaveTrack.domain;


import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by vane on 2014/11/27.
 */
@Entity
@Table(name="leavedays")
public class LeaveDays implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    private LocalDate yearEmployed;

    private int sickDaysLeft=0;
    private int sickDaysTotal=0;
    private int familyDaysLeft=0;
    private int familyDaysTotal=0;
    private int maternityDaysLeft=0;
    private int maternityDaysTotal=0;
    private int annualDaysLeft=0;
    private int annualDaysTotal=0;

     @OneToOne(mappedBy ="leaveDays")//maps to the Child table domain as in the Parent table
     private Employee employee; //Parent table class (Domain)

    public int getMaternityDaysTotal() {
        return maternityDaysTotal;
    }

    public void setMaternityDaysTotal(int maternityDaysTotal) {
        this.maternityDaysTotal = maternityDaysTotal;
    }

    public int getMaternityDaysLeft() {
        return maternityDaysLeft;
    }

    public void setMaternityDaysLeft(int maternityDaysLeft) {
        this.maternityDaysLeft = maternityDaysLeft;
    }

    public int getFamilyDaysTotal() {
        return familyDaysTotal;
    }

    public void setFamilyDaysTotal(int familyDaysTotal) {
        this.familyDaysTotal = familyDaysTotal;
    }

    public int getFamilyDaysLeft() {
        return familyDaysLeft;
    }

    public void setFamilyDaysLeft(int familyDaysLeft) {
        this.familyDaysLeft = familyDaysLeft;
    }

    public int getSickDaysTotal() {
        return sickDaysTotal;
    }

    public void setSickDaysTotal(int sickDaysTotal) {
        this.sickDaysTotal = sickDaysTotal;
    }

    public int getSickDaysLeft() {
        return sickDaysLeft;
    }

    public void setSickDaysLeft(int sickDaysLeft) {
        this.sickDaysLeft = sickDaysLeft;
    }

    public LocalDate getYearEmployed() {
        return yearEmployed;
    }

    public void setYearEmployed(LocalDate yearEmployed) {
        this.yearEmployed = yearEmployed;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public int getAnnualDaysTotal() {
        return annualDaysTotal;
    }

    public void setAnnualDaysTotal(int annualDaysTotal) {
        this.annualDaysTotal = annualDaysTotal;
    }

    public int getAnnualDaysLeft() {
        return annualDaysLeft;
    }

    public void setAnnualDaysLeft(int annualDaysLeft) {
        this.annualDaysLeft = annualDaysLeft;
    }
}