package com.lemon.leacc.leacc1.Model;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class Sales implements Serializable {
    @GeneratedValue
    @Id
    private int SalesId;


    @NotNull
    @ManyToOne
    @JsonBackReference(value = "customer")
    @JoinColumn(name = "customer_id")
    private Customer customer;
    private String billNo;
    @Temporal(TemporalType.DATE)
    private Date Date;
    private String salesDescription;

    @ManyToOne
    @JsonBackReference(value = "salesAgent")
    @JoinColumn(name = "sales_agent_id")
    private SalesAgent salesAgent;

    @Cascade(org.hibernate.annotations.CascadeType.DELETE)
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JsonBackReference(value = "vehicle")
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    private double startKm;
    private double endKm;

    @OneToMany(mappedBy = "sales", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<SalesProduct> salesProducts;


    @ManyToOne
    @JsonBackReference(value = "fiscalAccount")
    @JoinColumn(name = "fiscal_account_id")
    private FiscalAccount fiscalAccount;

    public String getVehicleDescription() {
        return this.getVehicle().getVehicleModel()+" || "+this.getVehicle().getPlateNumber();
    }

    public String getProducts(){
        String products="";
        for (SalesProduct pro:this.getSalesProducts()) {
            products+=", "+pro.getProduct().getProductDescription();
        }
        return products;
    }

    public double getTotalAmount(){
        double sum=0;
        for (SalesProduct pro:this.getSalesProducts()) {
            sum+=pro.getAmount();
        }
        return sum;
    }


    public int getSalesId() {
        return SalesId;
    }

    public void setSalesId(int salesId) {
        SalesId = salesId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
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

    public String getSalesDescription() {
        return salesDescription;
    }

    public void setSalesDescription(String salesDescription) {
        this.salesDescription = salesDescription;
    }

    public SalesAgent getSalesAgent() {
        return salesAgent;
    }

    public void setSalesAgent(SalesAgent salesAgent) {
        this.salesAgent = salesAgent;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
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

    public List<SalesProduct> getSalesProducts() {
        return salesProducts;
    }

    public void setSalesProducts(List<SalesProduct> salesProducts) {
        this.salesProducts = salesProducts;
    }

    public FiscalAccount getFiscalAccount() {
        return fiscalAccount;
    }

    public void setFiscalAccount(FiscalAccount fiscalAccount) {
        this.fiscalAccount = fiscalAccount;
    }
}