package com.lemon.leacc.leacc1.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.xml.internal.ws.api.ha.StickyFeature;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class StockTransfer implements Serializable {
    @GeneratedValue
    @Id
    private int stockTransferId;
    @Temporal(TemporalType.DATE)
    private Date date;
    private String billNo;
    private String description;

    @ManyToOne
    @JoinColumn(name = "from_godown_id", nullable = false)
    private Godown fromGodown;

    @ManyToOne
    @JoinColumn(name = "to_godown_id", nullable = false)
    private Godown toGodown;


    @OneToMany(mappedBy = "stockTransfer",cascade = CascadeType.ALL)
    private List<InventoryTransferProduct> inventoryTransferProducts;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "fiscal_account_id")
    private FiscalAccount fiscalAccount;


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<InventoryTransferProduct> getInventoryTransferProducts() {
        return inventoryTransferProducts;
    }

    public void setInventoryTransferProducts(List<InventoryTransferProduct> inventoryTransferProducts) {
        this.inventoryTransferProducts = inventoryTransferProducts;
    }


    public int getStockTransferId() {
        return stockTransferId;
    }

    public void setStockTransferId(int stockTransferId) {
        this.stockTransferId = stockTransferId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    public Godown getFromGodown() {
        return fromGodown;
    }

    public void setFromGodown(Godown fromGodown) {
        this.fromGodown = fromGodown;
    }

    public Godown getToGodown() {
        return toGodown;
    }

    public void setToGodown(Godown toGodown) {
        this.toGodown = toGodown;
    }

    public FiscalAccount getFiscalAccount() {
        return fiscalAccount;
    }

    public void setFiscalAccount(FiscalAccount fiscalAccount) {
        this.fiscalAccount = fiscalAccount;
    }

    @Override
    public String toString() {
        return "StockTransfer{" +
                "stockTransferId=" + stockTransferId +
                ", date=" + date +
                ", billNo='" + billNo + '\'' +
                ", description='" + description + '\'' +
                ", fromGodown=" + fromGodown +
                ", toGodown=" + toGodown +
                ", inventoryTransferProducts=" + inventoryTransferProducts +
                ", fiscalAccount=" + fiscalAccount +
                '}';
    }
}
