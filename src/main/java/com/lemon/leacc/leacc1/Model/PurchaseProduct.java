package com.lemon.leacc.leacc1.Model;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
public class PurchaseProduct implements Serializable {
    @GeneratedValue
    @Id
    private int purcahseProductId;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;


    @ManyToOne
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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "purchase_entry_id")
    private Purchase purchase;

    public int getPurcahseProductId() {
        return purcahseProductId;
    }

    public void setPurcahseProductId(int purcahseProductId) {
        this.purcahseProductId = purcahseProductId;
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

    public Purchase getPurchase() {
        return purchase;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }


}
