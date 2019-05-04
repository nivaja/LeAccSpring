package com.lemon.leacc.leacc1.Model;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class JournalDebit implements Serializable {

    @javax.persistence.Id
    @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn(name = "debit_account_id")
    private Account debitAccount;

    @ManyToOne
    @JoinColumn(name = "debit_sub_account_id")
    private SubAccount debitSubAccount;

    private double debitAmount;
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

    public Account getDebitAccount() {
        return debitAccount;
    }

    public void setDebitAccount(Account debitAccount) {
        this.debitAccount = debitAccount;
    }

    public SubAccount getDebitSubAccount() {
        return debitSubAccount;
    }

    public void setDebitSubAccount(SubAccount debitSubAccount) {
        this.debitSubAccount = debitSubAccount;
    }

    public double getDebitAmount() {
        return debitAmount;
    }

    public void setDebitAmount(double debitAmount) {
        this.debitAmount = debitAmount;
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
