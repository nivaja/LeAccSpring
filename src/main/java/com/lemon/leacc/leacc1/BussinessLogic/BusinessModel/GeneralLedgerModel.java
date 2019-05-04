package com.lemon.leacc.leacc1.BussinessLogic.BusinessModel;

import java.util.Date;

public class GeneralLedgerModel {
    private Date date;
    private String particulars;
    private double debitAmount;
    private double creditAmount;

    public GeneralLedgerModel(Date date, String particulars, double debitAmount, double creditAmount) {
        this.date = date;
        this.particulars = particulars;
        this.debitAmount = debitAmount;
        this.creditAmount = creditAmount;
    }

    public GeneralLedgerModel() {
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getParticulars() {
        return particulars;
    }

    public void setParticulars(String particulars) {
        this.particulars = particulars;
    }

    public double getDebitAmount() {
        return debitAmount;
    }

    public void setDebitAmount(double debitAmount) {
        this.debitAmount = debitAmount;
    }

    public double getCreditAmount() {
        return creditAmount;
    }

    public void setCreditAmount(double creditAmount) {
        this.creditAmount = creditAmount;
    }

    @Override
    public String toString() {
        return "GeneralLedgerModel{" +
                "date=" + date +
                ", particulars='" + particulars + '\'' +
                ", debitAmount=" + debitAmount +
                ", creditAmount=" + creditAmount +
                '}';
    }
}
