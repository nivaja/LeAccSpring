package com.lemon.leacc.leacc1.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Entity
public class FinishedProductMap implements Serializable {
    @GeneratedValue
    @Id
    private int finishedProductMapId;

    private  String description;

    @NotNull
    @ManyToOne
    @JsonBackReference(value = "productToMap")
    @JoinColumn(name = "product_id",nullable = false)
    private Product productToMap;

    private double quantity;

    @OneToMany(mappedBy = "finishedProductMap",cascade = CascadeType.ALL)
    private List<FinishedProductMapItem> finishedProductMapItem;

    @ManyToOne
    @JsonBackReference(value = "fiscalAccount")
    @JoinColumn(name = "fiscal_account_id", nullable = false)
    private FiscalAccount fiscalAccount;

    public int getFinishedProductMapId() {
        return finishedProductMapId;
    }

    public void setFinishedProductMapId(int finishedProductMapId) {
        this.finishedProductMapId = finishedProductMapId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Product getProductToMap() {
        return productToMap;
    }

    public void setProductToMap(Product productToMap) {
        this.productToMap = productToMap;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public List<FinishedProductMapItem> getFinishedProductMapItem() {
        return finishedProductMapItem;
    }

    public void setFinishedProductMapItem(List<FinishedProductMapItem> finishedProductMapItem) {
        this.finishedProductMapItem = finishedProductMapItem;
    }

    public FiscalAccount getFiscalAccount() {
        return fiscalAccount;
    }

    public void setFiscalAccount(FiscalAccount fiscalAccount) {
        this.fiscalAccount = fiscalAccount;
    }

    @Override
    public String toString() {
        return "FinishedProductMap{" +
                "finishedProductMapId=" + finishedProductMapId +
                ", description='" + description + '\'' +
                ", productToMap=" + productToMap +
                ", quantity=" + quantity +
                ", finishedProductMapItem=" + finishedProductMapItem +
                ", fiscalAccount=" + fiscalAccount +
                '}';
    }
}
