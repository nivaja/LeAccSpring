package com.lemon.leacc.leacc1.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Account implements Serializable{
    @Id
    @GeneratedValue
    private int accountId;
    private String accountDescription;


    @JsonBackReference(value = "accountType")
    @ManyToOne
    @JoinColumn(name = "account_type_id")
    private AccountType accountType;

    @OneToMany(mappedBy = "account",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<SubAccount> subAccounts;

//    @ManyToOne
//    @JsonBackReference
//    @JoinColumn(name = "account_type_group_id")
//    private AccountTypeGroup accountTypeGroup;

    @JsonBackReference(value = "fiscalAccount")
    @ManyToOne
    @JoinColumn(name = "fiscal_account_id")
    private FiscalAccount fiscalAccount;

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getAccountDescription() {
        return accountDescription;
    }

    public void setAccountDescription(String accountDescription) {
        this.accountDescription = accountDescription;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public List<SubAccount> getSubAccounts() {
        return subAccounts;
    }

    public void setSubAccounts(List<SubAccount> subAccounts) {
        this.subAccounts = subAccounts;
    }

    public FiscalAccount getFiscalAccount() {
        return fiscalAccount;
    }

    public void setFiscalAccount(FiscalAccount fiscalAccount) {
        this.fiscalAccount = fiscalAccount;
    }
}
