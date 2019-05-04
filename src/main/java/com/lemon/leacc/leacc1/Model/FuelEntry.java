package com.lemon.leacc.leacc1.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class FuelEntry implements Serializable {
    @GeneratedValue
    @Id
    private int fuelEntryId;

    @Temporal(TemporalType.DATE)
    private Date date;
    private String description;
    private double recordedKm;
    private double fuelQuantity;
    private double fuelRate;
    private double totalAmount;

    @JsonBackReference(value = "vehicle")
    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    @ManyToOne
    @JoinColumn(name = "fiscal_account_id")
    @JsonBackReference(value = "fiscalAccount")
    private FiscalAccount fiscalAccount;

    public FiscalAccount getFiscalAccount() {
        return fiscalAccount;
    }

    public void setFiscalAccount(FiscalAccount fiscalAccount) {
        this.fiscalAccount = fiscalAccount;
    }

    public int getFuelEntryId() {
        return fuelEntryId;
    }

    public void setFuelEntryId(int fuelEntryId) {
        this.fuelEntryId = fuelEntryId;
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

    public double getRecordedKm() {
        return recordedKm;
    }

    public void setRecordedKm(double recordedKm) {
        this.recordedKm = recordedKm;
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public double getFuelRate() {
        return fuelRate;
    }

    public void setFuelRate(double fuelRate) {
        this.fuelRate = fuelRate;
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
}
