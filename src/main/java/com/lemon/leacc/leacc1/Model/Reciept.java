package com.lemon.leacc.leacc1.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class Reciept implements Serializable {
    @GeneratedValue
    @Id
    private int recieptId;

    @Temporal(TemporalType.DATE)
    private Date date;
    private String billNo;



    @ManyToOne
    @JsonBackReference(value = "cashSubAccount")
    @JoinColumn(name = "cash_sub_account_id")
    private SubAccount cashSubAccount;

    private String chequeNo;
    private String description;

    @OneToMany(mappedBy = "reciept", cascade = CascadeType.ALL)
    private List<RecieptAccount> recieptAccount;

    @ManyToOne
    @JsonBackReference(value = "fiscalAccount")
    @JoinColumn(name = "fiscal_account_id")
    private FiscalAccount fiscalAccount;

    public int getRecieptId() {
        return recieptId;
    }

    public void setRecieptId(int recieptId) {
        this.recieptId = recieptId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    public SubAccount getCashSubAccount() {
        return cashSubAccount;
    }

    public void setCashSubAccount(SubAccount cashSubAccount) {
        this.cashSubAccount = cashSubAccount;
    }

    public String getChequeNo() {
        return chequeNo;
    }

    public void setChequeNo(String chequeNo) {
        this.chequeNo = chequeNo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<RecieptAccount> getRecieptAccount() {
        return recieptAccount;
    }

    public void setRecieptAccount(List<RecieptAccount> recieptAccount) {
        this.recieptAccount = recieptAccount;
    }

    public FiscalAccount getFiscalAccount() {
        return fiscalAccount;
    }

    public void setFiscalAccount(FiscalAccount fiscalAccount) {
        this.fiscalAccount = fiscalAccount;
    }
}
