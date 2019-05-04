package com.lemon.leacc.leacc1.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class InventoryTransferProduct implements Serializable {
    @GeneratedValue
    @Id
    private int inventoryTransferProductId;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private double quantity;
    private String remarks;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "stock_transfer_id")
    private StockTransfer stockTransfer;

    public int getInventoryTransferProductId() {
        return inventoryTransferProductId;
    }

    public void setInventoryTransferProductId(int inventoryTransferProductId) {
        this.inventoryTransferProductId = inventoryTransferProductId;
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

    public StockTransfer getStockTransfer() {
        return stockTransfer;
    }

    public void setStockTransfer(StockTransfer stockTransfer) {
        this.stockTransfer = stockTransfer;
    }

}
