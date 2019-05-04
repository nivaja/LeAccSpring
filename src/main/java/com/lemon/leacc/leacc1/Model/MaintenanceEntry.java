package com.lemon.leacc.leacc1.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Date;

@Entity
public class MaintenanceEntry {
    @GeneratedValue
    @Id
    private int maintenanceEntryId;

    @Temporal(TemporalType.DATE)
    private Date date;
    private String description;
    private String billNo;
    private double recordedKm;
    private double maintenanceDetail;
    private double remarks;
    private double totalAmount;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    @ManyToOne
    @JoinColumn(name = "fiscal_account_id")
    private FiscalAccount fiscalAccount;

    public int getMaintenanceEntryId() {
        return maintenanceEntryId;
    }

    public void setMaintenanceEntryId(int maintenanceEntryId) {
        this.maintenanceEntryId = maintenanceEntryId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    public double getRecordedKm() {
        return recordedKm;
    }

    public void setRecordedKm(double recordedKm) {
        this.recordedKm = recordedKm;
    }

    public double getMaintenanceDetail() {
        return maintenanceDetail;
    }

    public void setMaintenanceDetail(double maintenanceDetail) {
        this.maintenanceDetail = maintenanceDetail;
    }

    public double getRemarks() {
        return remarks;
    }

    public void setRemarks(double remarks) {
        this.remarks = remarks;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public FiscalAccount getFiscalAccount() {
        return fiscalAccount;
    }

    public void setFiscalAccount(FiscalAccount fiscalAccount) {
        this.fiscalAccount = fiscalAccount;
    }
}
