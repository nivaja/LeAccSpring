package com.lemon.leacc.leacc1.Model;


import com.fasterxml.jackson.annotation.*;
import com.lemon.leacc.leacc1.Auth.Company;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class FiscalAccount implements Serializable {
    @GeneratedValue
    @Id
    private int fiscalAccountId;
    private String fiscalAccountDescription;


    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "company_id")
    private Company company;

//    @JsonIgnore
//    @OneToMany(mappedBy = "fiscalAccount")
//    private List<Account> accounts;

//    @JsonIgnore
//    @OneToMany(mappedBy = "fiscalAccount")
//    private List<SubAccount> subAccounts;
//
//    @JsonIgnore
//    @OneToMany(mappedBy = "fiscalAccount")
//    private List<Journal> journals;
//
//    @JsonIgnore
//    @OneToMany(mappedBy = "fiscalAccount")
//    private List<Vendor> vendors;

//    @JsonIgnore
//    @OneToMany(mappedBy = "fiscalAccount")
//    private List<Sales> sales;




    public int getFisacalAccountId() {
        return fiscalAccountId;
    }

    public void setFisacalAccountId(int fisacalAccountId) {
        this.fiscalAccountId = fisacalAccountId;
    }

    public String getFiscalAccountDescription() {
        return fiscalAccountDescription;
    }

    public void setFiscalAccountDescription(String fiscalAccountDescription) {
        this.fiscalAccountDescription = fiscalAccountDescription;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
//
//    public List<Account> getAccounts() {
//        return accounts;
//    }
//
//    public void setAccounts(List<Account> accounts) {
//        this.accounts = accounts;
//    }

//    public List<SubAccount> getSubAccounts() {
//        return subAccounts;
//    }
//
//    public void setSubAccounts(List<SubAccount> subAccounts) {
//        this.subAccounts = subAccounts;
//    }
//
//    public List<Journal> getJournals() {
//        return journals;
//    }
//
//    public void setJournals(List<Journal> journals) {
//        this.journals = journals;
//    }
//
//    public int getFiscalAccountId() {
//        return fiscalAccountId;
//    }
//
//    public void setFiscalAccountId(int fiscalAccountId) {
//        this.fiscalAccountId = fiscalAccountId;
//    }
//
//    public List<Vendor> getVendors() {
//        return vendors;
//    }
//
//    public void setVendors(List<Vendor> vendors) {
//        this.vendors = vendors;
//    }

//    public List<Sales> getSales() {
//        return sales;
//    }
//
//    public void setSales(List<Sales> sales) {
//        this.sales = sales;
//    }
}