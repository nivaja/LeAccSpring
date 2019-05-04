package com.lemon.leacc.leacc1.Model;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
public class SalesProduct implements Serializable {
    @GeneratedValue
    @Id
    private int salesProductId;
    
    @ManyToOne
    @JsonBackReference(value = "product")
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JsonBackReference(value = "godown")
    @JoinColumn(name = "godown_id")
    private Godown godown;

    @NotNull
    private double quantity;
    @NotNull
    private double rate;
    @NotNull
    private double amount;
    private double discountPercent;
    private double discountAmount;
    private double netAmount;


    @ManyToOne
    @JsonBackReference(value = "sales")
    @JoinColumn(name = "sales_entry_id")
    private Sales sales;

    public int getSalesProductId() {
        return salesProductId;
    }

    public void setSalesProductId(int salesProductId) {
        this.salesProductId = salesProductId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Godown getGodown() {
        return godown;
    }

    public void setGodown(Godown godown) {
        this.godown = godown;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(double discountPercent) {
        this.discountPercent = discountPercent;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(double discountAmount) {
        this.discountAmount = discountAmount;
    }

    public double getNetAmount() {
        return netAmount;
    }

    public void setNetAmount(double netAmount) {
        this.netAmount = netAmount;
    }

    public Sales getSales() {
        return sales;
    }

    public void setSales(Sales sales) {
        this.sales = sales;
    }
}