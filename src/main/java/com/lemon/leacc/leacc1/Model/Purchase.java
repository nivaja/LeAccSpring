package com.lemon.leacc.leacc1.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class Purchase implements Serializable {
    @GeneratedValue
    @Id
    private int purchaseId;
    @NotNull
    @ManyToOne
    @JsonBackReference(value = "vendor")
    @JoinColumn(name = "vendor_id")
    private Vendor vendor;
    private String billNo;
    @Temporal(TemporalType.DATE)
    private Date Date;
    private String purchaseDescription;

    @ManyToOne
    @JsonBackReference(value = "vehicle")
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    private double startKm;
    private double endKm;

    @OneToMany(mappedBy = "purchase", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<PurchaseProduct> purchaseProducts;

    @ManyToOne
    @JsonBackReference(value = "fiscalAccount")
    @JoinColumn(name = "fiscal_account_id")
    private FiscalAccount fiscalAccount;

    public int getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(int purchaseId) {
        this.purchaseId = purchaseId;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    public java.util.Date getDate() {
        return Date;
    }

    public void setDate(java.util.Date date) {
        Date = date;
    }

    public String getPurchaseDescription() {
        return purchaseDescription;
    }

    public void setPurchaseDescription(String purchaseDescription) {
        this.purchaseDescription = purchaseDescription;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public List<PurchaseProduct> getPurchaseProducts() {
        return purchaseProducts;
    }

    public void setPurchaseProducts(List<PurchaseProduct> purchaseProducts) {
        this.purchaseProducts = purchaseProducts;
    }

    public FiscalAccount getFiscalAccount() {
        return fiscalAccount;
    }

    public void setFiscalAccount(FiscalAccount fiscalAccount) {
        this.fiscalAccount = fiscalAccount;
    }

    public double getStartKm() {
        return startKm;
    }

    public void setStartKm(double startKm) {
        this.startKm = startKm;
    }

    public double getEndKm() {
        return endKm;
    }

    public void setEndKm(double endKm) {
        this.endKm = endKm;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "purchaseId=" + purchaseId +
                ", vendor=" + vendor +
                ", billNo='" + billNo + '\'' +
                ", Date=" + Date +
                ", purchaseDescription='" + purchaseDescription + '\'' +
                ", vehicle=" + vehicle +
                ", purchaseProducts=" + purchaseProducts +
                ", fiscalAccount=" + fiscalAccount +
                '}';
    }


    public String getVehicleDescription() {
        return this.getVehicle().getVehicleModel()+" || "+this.getVehicle().getPlateNumber();
    }

    public String getProducts(){
        String products="";
        for (PurchaseProduct pro:this.getPurchaseProducts()) {
            products+=", "+pro.getProduct().getProductDescription();
        }
        return products;
    }

    public double getTotalAmount(){
        double sum=0;
        for (PurchaseProduct pro:this.getPurchaseProducts()) {
            sum+=pro.getAmount();
        }
        return sum;
    }
}
