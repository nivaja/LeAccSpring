package com.lemon.leacc.leacc1.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Employee implements Serializable {
    @Id
    @GeneratedValue
    private int employeeId;
    private String name;
    private String address;
    private String phone;
    private String email;
    @NotNull
    private double salary;
    @NotNull
    private String salaryType;

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date joinDate;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "fiscal_account_id")
    private FiscalAccount fiscalAccount;


    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getSalaryType() {
        return salaryType;
    }

    public void setSalaryType(String salaryType) {
        this.salaryType = salaryType;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public FiscalAccount getFiscalAccount() {
        return fiscalAccount;
    }

    public void setFiscalAccount(FiscalAccount fiscalAccount) {
        this.fiscalAccount = fiscalAccount;
    }
}
