package com.lemon.leacc.leacc1.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class Journal implements Serializable {
    @GeneratedValue
    @Id
    private int journalId;
    @Temporal(TemporalType.DATE)
    private Date transactionDate;

    private String journalNo;
    private String description;


    @JsonBackReference(value = "journalCredits")
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "journal")
    private List<JournalCredit> journalCredits;

    @JsonIgnore
    @JsonBackReference(value = "journalDebits")
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "journal")
    private List<JournalDebit> journalDebits;

    @JsonBackReference(value = "fiscalAccount")
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fiscal_account_id")
    private FiscalAccount fiscalAccount;

    public String getJournalNo() {
        return journalNo;
    }

    public void setJournalNo(String journalNo) {
        this.journalNo = journalNo;
    }

    public int getJournalId() {
        return journalId;
    }

    public void setJournalId(int journalId) {
        this.journalId = journalId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public List<JournalCredit> getJournalCredits() {
        return journalCredits;
    }

    public void setJournalCredits(List<JournalCredit> journalCredits) {
        this.journalCredits = journalCredits;
    }

    public List<JournalDebit> getJournalDebits() {
        return journalDebits;
    }

    public void setJournalDebits(List<JournalDebit> journalDebits) {
        this.journalDebits = journalDebits;
    }

    public FiscalAccount getFiscalAccount() {
        return fiscalAccount;
    }

    public void setFiscalAccount(FiscalAccount fiscalAccount) {
        this.fiscalAccount = fiscalAccount;
    }
}
