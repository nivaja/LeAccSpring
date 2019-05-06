package com.lemon.leacc.leacc1.BussinessLogic;

import com.lemon.leacc.leacc1.Auth.SessionService;
import com.lemon.leacc.leacc1.Model.*;
import com.lemon.leacc.leacc1.RestRepo.FiscalAccountRepo;
import com.lemon.leacc.leacc1.RestRepo.SalesRepo;
import com.lemon.leacc.leacc1.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.List;



public class Dashboard {
    @Autowired
    SessionService sessionService;
    @Autowired
    SalesRepo salesRepo;

    @Autowired
    PaymentService paymentService;

    FiscalAccount fiscalAccount;


    DecimalFormat df = new DecimalFormat("#,###,###,###,###");
    public Dashboard(FiscalAccount fiscalAccount){
      this.fiscalAccount = fiscalAccount;
    }

    public double sales(){
        double amount = 0;
        for (Sales sales: fiscalAccount.getSales()) {
            for (SalesProduct salesProduct:sales.getSalesProducts()) {
                amount+=salesProduct.getAmount();
            }
        }

        return Math.round(amount);
    }

    public double expenses(){
       List<Payment> pa= fiscalAccount.getPayments();
       double totalExpenses=0;
       for(Payment p:pa){
           for (PaymentAccount paa : p.getPaymentAccount())
           {
               totalExpenses+=paa.getAmount();
           }

       }
        return Math.round(totalExpenses);
    }

    public double income(){
        List<Reciept> pa= fiscalAccount.getReciepts();
        double totalIncome=0;
        for(Reciept p:pa){
            for (RecieptAccount paa : p.getRecieptAccount())
            {
                totalIncome+=paa.getAmount();
            }

        }
        return Math.round(totalIncome+sales());
    }

    public double netProfit(){
        return income()-expenses();
    }

    public int customer()
    {
        return fiscalAccount.getCustomers().size();
    }

    public List<Sales> salesSummary(){
        return fiscalAccount.getSales();
    }

    public List<Purchase> purchaseSummary(){
        return fiscalAccount.getPurchases();
    }

}
