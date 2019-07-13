package com.lemon.leacc.leacc1.Auth;

import com.fasterxml.jackson.annotation.*;
import com.lemon.leacc.leacc1.Model.FiscalAccount;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class Company implements Serializable{
    @Id
    @GeneratedValue
    private int companyId;
    private String companyName;
    private String phone;
    private String email;
    private String password;
    @NotNull
    @Column(unique = true, nullable = false)
    private String companyInitial;

    private String dateFormat;

    @Temporal(TemporalType.DATE)
    private Date initialFiscalYear;

    @Temporal(TemporalType.DATE)
    private Date finalFiscalYear;


//    @JsonBackReference
    @JsonIgnore
    @OneToMany(mappedBy = "company")
    private List<FiscalAccount> fiscalAccount;

    @JsonIgnore
    @OneToMany(mappedBy ="Company" ,cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    private List<AppUser> users;


    public Company(){}

    public Company(String companyName, String phone, String email, String password, String companyInitial) {
        this.companyName = companyName;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.companyInitial = companyInitial;
    }



    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
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


    public String getCompanyInitial() {
        return companyInitial;
    }

    public void setCompanyInitial(String companyInitial) {
        this.companyInitial = companyInitial;
    }

    public String getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
    }

    public Date getInitialFiscalYear() {
        return initialFiscalYear;
    }

    public void setInitialFiscalYear(Date initialFiscalYear) {
        this.initialFiscalYear = initialFiscalYear;
    }

    public Date getFinalFiscalYear() {
        return finalFiscalYear;
    }

    public void setFinalFiscalYear(Date finalFiscalYear) {
        this.finalFiscalYear = finalFiscalYear;
    }

    public List<FiscalAccount> getFiscalAccounts() {
        return fiscalAccount;
    }

    public void setFiscalAccounts(List<FiscalAccount> fiscalAccount) {
        this.fiscalAccount = fiscalAccount;
    }

    public List<AppUser> getUsers() {
        return users;
    }

    public void setUsers(List<AppUser> users) {
        this.users = users;
    }


}