package com.lemon.leacc.leacc1.BussinessLogic.BusinessModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StockLegderModel {
    private Date date;
    private String particular;
    private double issuedQuantity;
    private double receivedQuantity;
    private double balance;


}
