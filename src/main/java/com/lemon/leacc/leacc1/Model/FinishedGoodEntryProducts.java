package com.lemon.leacc.leacc1.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class FinishedGoodEntryProducts {
    @GeneratedValue
    @Id
    private int finishedGoodEntryProductId;
    @JsonBackReference(value = "product")
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private double quantity;
    private String remarks;

    @JsonBackReference(value = "finishedGoodEntryId")
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "finished_good_entry_id")
    private FinishedGoodEntry finishedGoodEntry;


    public FinishedGoodEntry getFinishedGoodEntry() {
        return finishedGoodEntry;
    }

    public void setFinishedGoodEntry(FinishedGoodEntry finishedGoodEntry) {
        this.finishedGoodEntry = finishedGoodEntry;
    }

    public int getFinishedGoodEntryProductId() {
        return finishedGoodEntryProductId;
    }

    public void setFinishedGoodEntryProductId(int finishedGoodEntryProductId) {
        this.finishedGoodEntryProductId = finishedGoodEntryProductId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
