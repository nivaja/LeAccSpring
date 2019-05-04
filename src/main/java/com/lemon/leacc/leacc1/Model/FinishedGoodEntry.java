package com.lemon.leacc.leacc1.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class FinishedGoodEntry implements Serializable{
    @GeneratedValue
    @Id
    private int finishedGoodEntryId;

    @Temporal(TemporalType.DATE)
    private Date date;
    private String billNo;
    private String description;

    @JsonBackReference(value = "toGowdown")
    @ManyToOne
    @JoinColumn(name = "to_godown_id")
    private Godown toGodown;

    @OneToMany(mappedBy = "finishedGoodEntry",cascade = CascadeType.ALL)
    private List<FinishedGoodEntryProducts> finishedGoodEntryProducts;

    @JsonBackReference(value="fiscalAccount")
    @ManyToOne
    private FiscalAccount fiscalAccount;

    public FiscalAccount getFiscalAccount() {
        return fiscalAccount;
    }

    public void setFiscalAccount(FiscalAccount fiscalAccount) {
        this.fiscalAccount = fiscalAccount;
    }

    public int getFinishedGoodEntryId() {
        return finishedGoodEntryId;
    }

    public void setFinishedGoodEntryId(int finishedGoodEntryId) {
        this.finishedGoodEntryId = finishedGoodEntryId;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Godown getToGodown() {
        return toGodown;
    }

    public void setToGodown(Godown toGodown) {
        this.toGodown = toGodown;
    }

    public List<FinishedGoodEntryProducts> getFinishedGoodEntryProducts() {
        return finishedGoodEntryProducts;
    }

    public void setFinishedGoodEntryProducts(List<FinishedGoodEntryProducts> finishedGoodEntryProducts) {
        this.finishedGoodEntryProducts = finishedGoodEntryProducts;
    }

    @Override
    public String toString() {
        return "FinishedGoodEntry{" +
                "finishedGoodEntryId=" + finishedGoodEntryId +
                ", date=" + date +
                ", billNo='" + billNo + '\'' +
                ", description='" + description + '\'' +
                ", toGodown=" + toGodown +
                ", finishedGoodEntryProducts=" + finishedGoodEntryProducts +
                ", fiscalAccount=" + fiscalAccount +
                '}';
    }
}
