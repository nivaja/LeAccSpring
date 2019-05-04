package com.lemon.leacc.leacc1.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class SubAccount implements Serializable {
    @Id
    @GeneratedValue
    private int subAccountId;
    private String subAccountDescription;


    @ManyToOne
    @JsonBackReference(value = "account")
    @JoinColumn(name = "account_id")
    private Account account;


//    @JsonBackReference
//    @OneToMany(mappedBy = "cashSubAccount",cascade = CascadeType.ALL)
//    private List<Payment> payments;

    @ManyToOne
    @JsonBackReference(value = "fiscalAccount")
    @JoinColumn(name = "fiscal_account_id")
    private FiscalAccount fiscalAccount;

    public int getSubAccountId() {
        return subAccountId;
    }

    public void setSubAccountId(int subAccountId) {
        this.subAccountId = subAccountId;
    }

    public String getSubAccountDescription() {
        return subAccountDescription;
    }

    public void setSubAccountDescription(String subAccountDescription) {
        this.subAccountDescription = subAccountDescription;
    }



    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public FiscalAccount getFiscalAccount() {
        return fiscalAccount;
    }

    public void setFiscalAccount(FiscalAccount fiscalAccount) {
        this.fiscalAccount = fiscalAccount;
    }
}
