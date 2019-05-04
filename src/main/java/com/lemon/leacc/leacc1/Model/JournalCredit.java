package com.lemon.leacc.leacc1.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class JournalCredit implements Serializable {
    @Id
    @GeneratedValue
    private int id;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "credit_account_id")
    private Account creditAccount;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "credit_sub_account_id")
    private SubAccount creditSubAccount;

    private double creditAmount;
    private String description;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "journal_id")
    private Journal journal;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Account getCreditAccount() {
        return creditAccount;
    }

    public void setCreditAccount(Account creditAccount) {
        this.creditAccount = creditAccount;
    }

    public SubAccount getCreditSubAccount() {
        return creditSubAccount;
    }

    public void setCreditSubAccount(SubAccount creditSubAccount) {
        this.creditSubAccount = creditSubAccount;
    }

    public double getCreditAmount() {
        return creditAmount;
    }

    public void setCreditAmount(double creditAmount) {
        this.creditAmount = creditAmount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Journal getJournal() {
        return journal;
    }

    public void setJournal(Journal journal) {
        this.journal = journal;
    }
}
