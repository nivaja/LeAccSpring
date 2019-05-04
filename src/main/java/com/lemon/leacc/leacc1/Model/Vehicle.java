package com.lemon.leacc.leacc1.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Vehicle implements Serializable {
    @Id
    @GeneratedValue
    private int vehicleId;
    private String vehicleModel;
    @NotNull
    private String plateNumber;
    private String billBookNo;
    @NotNull
    private String recordedKm;
    private double fuelCapacity;
    private double mileage;
    @Temporal(TemporalType.DATE)
    private Date addedDate;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "fiscal_account_id")
    private FiscalAccount fiscalAccount;

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getBillBookNo() {
        return billBookNo;
    }

    public void setBillBookNo(String billBookNo) {
        this.billBookNo = billBookNo;
    }

    public String getRecordedKm() {
        return recordedKm;
    }

    public void setRecordedKm(String recordedKm) {
        this.recordedKm = recordedKm;
    }

    public double getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(double fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    public double getMileage() {
        return mileage;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    public FiscalAccount getFiscalAccount() {
        return fiscalAccount;
    }

    public void setFiscalAccount(FiscalAccount fiscalAccount) {
        this.fiscalAccount = fiscalAccount;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleId=" + vehicleId +
                ", vehicleModel='" + vehicleModel + '\'' +
                ", plateNumber='" + plateNumber + '\'' +
                ", billBookNo='" + billBookNo + '\'' +
                ", recordedKm='" + recordedKm + '\'' +
                ", fuelCapacity=" + fuelCapacity +
                ", mileage=" + mileage +
                ", addedDate=" + addedDate +
                ", fiscalAccount=" + fiscalAccount +
                '}';
    }
}
