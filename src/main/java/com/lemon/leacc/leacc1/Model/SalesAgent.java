package com.lemon.leacc.leacc1.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class SalesAgent implements Serializable {
    @Id
    @GeneratedValue
    private int salesAgentId;
    @NotNull
    private String name;
    private String address;
    private String phone;
    private String email;
    private String bankName;
    private String bankNumber;
    private double creditLimit;
    private double creditDays;
    private double target;
    private double commissionPercent;


    @NotNull
    @Temporal(TemporalType.DATE)
    private Date JoinDate;

    @JsonBackReference(value = "fiscalAccount")
    @ManyToOne
    @JoinColumn(name = "fiscal_account_id")
    private FiscalAccount fiscalAccount;

    public int getSalesAgentId() {
        return salesAgentId;
    }

    public void setSalesAgentId(int salesAgentId) {
        this.salesAgentId = salesAgentId;
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

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankNumber() {
        return bankNumber;
    }

    public void setBankNumber(String bankNumber) {
        this.bankNumber = bankNumber;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }

    public double getCreditDays() {
        return creditDays;
    }

    public void setCreditDays(double creditDays) {
        this.creditDays = creditDays;
    }

    public double getTarget() {
        return target;
    }

    public void setTarget(double target) {
        this.target = target;
    }

    public double getCommissionPercent() {
        return commissionPercent;
    }

    public void setCommissionPercent(double commissionPercent) {
        this.commissionPercent = commissionPercent;
    }

    public Date getJoinDate() {
        return JoinDate;
    }

    public void setJoinDate(Date joinDate) {
        JoinDate = joinDate;
    }

    public FiscalAccount getFiscalAccount() {
        return fiscalAccount;
    }

    public void setFiscalAccount(FiscalAccount fiscalAccount) {
        this.fiscalAccount = fiscalAccount;
    }
}
