package com.lemon.leacc.leacc1.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Entity
public class Godown implements Serializable {
    @GeneratedValue
    @Id
    private int godownId;

    @NotNull
    private String godownDescription;

    private String Location;
    private String capacity;
    private String phone;
    private String stockLimit;

    @JsonBackReference(value = "fiscalAccount")
    @ManyToOne
    @JoinColumn(name = "fiscal_account_id")
    private FiscalAccount fiscalAccount;

    @JsonIgnore
    @OneToMany(mappedBy = "fromGodown",cascade = CascadeType.ALL)
    private List<StockTransfer> fromStockTransfers;

    @JsonIgnore
    @OneToMany(mappedBy = "toGodown",cascade = CascadeType.ALL)
    private List<StockTransfer> toStockTransfers;

    public List<StockTransfer> getFromStockTransfers() {
        return fromStockTransfers;
    }

    public List<StockTransfer> getToStockTransfers() {
        return toStockTransfers;
    }

    public void setToStockTransfers(List<StockTransfer> toStockTransfers) {
        this.toStockTransfers = toStockTransfers;
    }

    public void setFromStockTransfers(List<StockTransfer> fromStockTransfers) {
        this.fromStockTransfers = fromStockTransfers;
    }

    public int getGodownId() {
        return godownId;
    }

    public void setGodownId(int godownId) {
        this.godownId = godownId;
    }

    public String getGodownDescription() {
        return godownDescription;
    }

    public void setGodownDescription(String godownDescription) {
        this.godownDescription = godownDescription;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStockLimit() {
        return stockLimit;
    }


    public void setStockLimit(String stockLimit) {
        this.stockLimit = stockLimit;
    }

    public FiscalAccount getFiscalAccount() {
        return fiscalAccount;
    }

    public void setFiscalAccount(FiscalAccount fiscalAccount) {
        this.fiscalAccount = fiscalAccount;
    }

//    @Override
//    public String toString() {
//        return "Godown{" +
//                "godownId=" + godownId +
//                ", godownDescription='" + godownDescription + '\'' +
//                ", Location='" + Location + '\'' +
//                ", capacity='" + capacity + '\'' +
//                ", phone='" + phone + '\'' +
//                ", stockLimit='" + stockLimit + '\'' +
//                ", fiscalAccount=" + fiscalAccount +
//                '}';
//    }
}
