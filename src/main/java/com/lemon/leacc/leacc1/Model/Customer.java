package com.lemon.leacc.leacc1.Model;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class Customer implements Serializable {
    @Id
    @GeneratedValue
    private int customerId;
    @NotNull
    private String name;
    private String address;
    private String phone;
    private String email;
    private String bankName;
    private String bankNumber;
    private String creditLimit;
    private String creditDays;

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date JoinDate;

    @JsonIgnore
    //@JsonManagedReference
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fiscal_account_id")
    private FiscalAccount fiscalAccount;

    @JsonIgnore
    @OneToMany(mappedBy = "customer",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Sales> sales;



    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
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

    public String getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(String creditLimit) {
        this.creditLimit = creditLimit;
    }

    public String getCreditDays() {
        return creditDays;
    }

    public void setCreditDays(String creditDays) {
        this.creditDays = creditDays;
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

    public List<Sales> getSales() {
        return sales;
    }

    public void setSales(List<Sales> sales) {
        this.sales = sales;
    }
}
