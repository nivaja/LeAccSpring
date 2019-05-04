package com.lemon.leacc.leacc1.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class FinishedProductMapItem implements Serializable {
    @GeneratedValue
    @Id
    private int finishedProductMapItemId;

    @ManyToOne
    @JsonBackReference(value = "product")
    @JoinColumn(name = "product_id")
    private Product product;

    private double quantity;
    private String remarks;



    @ManyToOne
    @JoinColumn(name = "finished_product_map_id")
    @JsonBackReference(value = "finishedProductMap")
    private FinishedProductMap finishedProductMap;

    public int getFinishedProductMapItemId() {
        return finishedProductMapItemId;
    }

    public void setFinishedProductMapItemId(int finishedProductMapItemId) {
        this.finishedProductMapItemId = finishedProductMapItemId;
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

    public FinishedProductMap getFinishedProductMap() {
        return finishedProductMap;
    }

    public void setFinishedProductMap(FinishedProductMap finishedProductMap) {
        this.finishedProductMap = finishedProductMap;
    }
}
