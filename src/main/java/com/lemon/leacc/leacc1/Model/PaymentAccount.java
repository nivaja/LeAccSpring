package com.lemon.leacc.leacc1.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class PaymentAccount implements Serializable {
    @GeneratedValue
    @Id
    private int paymentAccountId;
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

    @JsonBackReference(value = "payment")
    @ManyToOne
    @JoinColumn(name = "payment_id")
    private Payment payment;

    public int getPaymentAccountId() {
        return paymentAccountId;
    }

    public void setPaymentAccountId(int paymentAccountId) {
        this.paymentAccountId = paymentAccountId;
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

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

}
