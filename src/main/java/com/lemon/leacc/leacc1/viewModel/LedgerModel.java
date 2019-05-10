package com.lemon.leacc.leacc1.viewModel;

import java.util.Date;

public class LedgerModel {
    private Date date;
    private String particular;
    private double payment;
    private double reciept;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getParticular() {
        return particular;
    }

    public void setParticular(String particular) {
        this.particular = particular;
    }

    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    public double getReciept() {
        return reciept;
    }

    public void setReciept(double reciept) {
        this.reciept = reciept;
    }
}
