package com.lemon.leacc.leacc1.Model;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class Payment implements Serializable{
    @GeneratedValue
    @Id
    private int paymentId;

    @Temporal(TemporalType.DATE)
    private Date date;

    private String billNo;


    private String chequeNo;
    private String description;

    @OneToMany(mappedBy = "payment",cascade = CascadeType.ALL)
    private List<PaymentAccount> paymentAccount;


    @JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="subAccountId")
    @ManyToOne
    @JoinColumn(name = "cash_sub_account_id")
    private SubAccount cashSubAccount;

    @ManyToOne
    @JoinColumn(name = "fiscal_account_id")
    private FiscalAccount fiscalAccount;

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
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

    public List<PaymentAccount> getPaymentAccount() {
        return paymentAccount;
    }

    public void setPaymentAccount(List<PaymentAccount> paymentAccount) {
        this.paymentAccount = paymentAccount;
    }

    public FiscalAccount getFiscalAccount() {
        return fiscalAccount;
    }

    public void setFiscalAccount(FiscalAccount fiscalAccount) {
        this.fiscalAccount = fiscalAccount;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentId=" + paymentId +
                ", date=" + date +
                ", billNo='" + billNo + '\'' +
                ", cashSubAccount=" + cashSubAccount +
                ", chequeNo='" + chequeNo + '\'' +
                ", description='" + description + '\'' +
                ", paymentAccount=" + paymentAccount +
                ", fiscalAccount=" + fiscalAccount +
                '}';
    }
}
