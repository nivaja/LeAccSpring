package com.lemon.leacc.leacc1.BussinessLogic.BusinessModel;

import java.util.Date;

public class StockLegderModel {
    private Date date;
    private String particular;
    private double issuedQuantity;
    private double receivedQuantity;

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

    public double getIssuedQuantity() {
        return issuedQuantity;
    }

    public void setIssuedQuantity(double issuedQuantity) {
        this.issuedQuantity = issuedQuantity;
    }

    public double getReceivedQuantity() {
        return receivedQuantity;
    }

    public void setReceivedQuantity(double receivedQuantity) {
        this.receivedQuantity = receivedQuantity;
    }
}
