package com.lemon.leacc.leacc1.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class RecieptAccount implements Serializable {
    @GeneratedValue
    @Id
    private int recieptAccountId;

    @ManyToOne
    @JsonBackReference(value = "account")
    @JoinColumn(name = "account_id")
    private Account account;

    @ManyToOne
    @JsonBackReference(value = "subAccount")
    @JoinColumn(name = "sub_account_id")
    private SubAccount subAccount;

    private double amount;
    private String remarks;

    @ManyToOne
    @JsonBackReference(value = "reciept")
    @JoinColumn(name = "reciept_id")
    private Reciept reciept;

    public int getRecieptAccountId() {
        return recieptAccountId;
    }

    public void setRecieptAccountId(int recieptAccountId) {
        this.recieptAccountId = recieptAccountId;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public SubAccount getSubAccount() {
        return subAccount;
    }

    public void setSubAccount(SubAccount subAccount) {
        this.subAccount = subAccount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Reciept getReciept() {
        return reciept;
    }

    public void setReciept(Reciept reciept) {
        this.reciept = reciept;
    }
}
