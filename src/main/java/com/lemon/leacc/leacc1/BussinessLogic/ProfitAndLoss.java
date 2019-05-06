package com.lemon.leacc.leacc1.BussinessLogic;

import com.lemon.leacc.leacc1.Auth.SessionService;
import com.lemon.leacc.leacc1.Model.*;
import com.lemon.leacc.leacc1.RestRepo.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProfitAndLoss {
    @Autowired
    AccountRepo accountRepo;
    @Autowired
    SalesRepo salesRepo;

    @Autowired
    PurchaseRepo purchaseRepo;
    @Autowired
    SessionService sessionService;

    @Autowired
    VoucherRecieptRepo voucherRecieptRepo;

    @Autowired
    VoucherRecieptAccountRepo voucherRecieptAccountRepo;

    @Autowired
    PaymentAccountRepo paymentAccountRepo;

    @Autowired
    AccountTypeRepo accountTypeRepo;
    @Autowired
    VoucherPaymentAccountRepo voucherPaymentAccountRepo;

   private FiscalAccount fiscalAccount;

    public ProfitAndLoss(FiscalAccount fiscalAccount){
        this.fiscalAccount=fiscalAccount;
    }


    public Map<String,Double> getDirectExpenses(){
        Map<String,Double> directExpensesAndTotalAmount =new HashMap<>();


        List<Account> directExpenses= accountRepo.findByFiscalAccountAndAccountType_AccountTypeDescription(fiscalAccount,"Direct Expenses");

        double purchaseAmount=0;
        for(Purchase purchase : purchaseRepo.getByFiscalAccount(fiscalAccount)){

            for(PurchaseProduct pp : purchase.getPurchaseProducts()){
                purchaseAmount+=pp.getAmount();
            }

        }
        directExpensesAndTotalAmount.put("Cost Of Good (Purchase)",purchaseAmount);

        double directExpAmount = 0;
        for (Account account:directExpenses) {
            double totalAmount=0;
            for(PaymentAccount paymentAccount:paymentAccountRepo.findByAccount(account)){
               totalAmount+= paymentAccount.getAmount();
                directExpAmount+=totalAmount;
            }
            directExpensesAndTotalAmount.put(account.getAccountDescription(),totalAmount);
        }
        directExpensesAndTotalAmount.put("Total Cost Of Goods Sold",purchaseAmount+directExpAmount);

        return directExpensesAndTotalAmount;
    }


    public Map<String,Double> income(){
        List<Account> incomeAccount = accountRepo.findByFiscalAccountAndAccountType_AccountTypeDescription(fiscalAccount,"income");
        Map<String,Double> accountAndTotalAmount =new HashMap<>();
        List<Sales> salesAccount=salesRepo.findAllByFiscalAccount(fiscalAccount);

        //double totalSales =0;
        double amount = 0;
        for (Sales sales: salesAccount) {
            for (SalesProduct salesProduct:sales.getSalesProducts()) {
               amount+=salesProduct.getAmount();
               // totalSales+=amount;
            }
            accountAndTotalAmount.put("Sales",amount);
        }

        double totalIncome=0;
        for (Account account:incomeAccount) {
            double totalAmount=0;
            for (RecieptAccount reciept:voucherRecieptAccountRepo.findByAccount(account) ) {
                totalAmount+=reciept.getAmount();
                totalIncome+=totalAmount;
            }
            accountAndTotalAmount.put(account.getAccountDescription(),totalAmount);
        }

        accountAndTotalAmount.put("Total Income",amount);
        return accountAndTotalAmount;
    }

//    public Map<String,Double> sales(){
//        List<Sales> salesAccount=salesRepo.findAllByFiscalAccount(fiscalAccount);
//        Map<String,Double> salesAndAmount =new HashMap<>();
//
//        for (Sales sales: salesAccount) {
//            double amount = 0;
//            for (SalesProduct salesProduct:sales.getSalesProducts()) {
//                amount+=salesProduct.getAmount();
//            }
//            salesAndAmount.put("Sales",amount);
//        }
//        return salesAndAmount;
//    }

    public Map<String,Double> getIndirectExpenses(){
        Map<String,Double> indirectExpensesAndAmount =new HashMap<>();
        List<Account> accounts = accountRepo.findByAccountTypeAndAccountDescriptionNotAndFiscalAccount(accountTypeRepo.findByAccountTypeDescription("expense"),"Direct Expenses", fiscalAccount);
       double totalIndirectExpenses =0;
        for(Account account: accounts){
            double totalAmount=0;
            for (PaymentAccount paymentAcc:voucherPaymentAccountRepo.findByAccount(account)) {
                totalAmount+=paymentAcc.getAmount();
                totalIndirectExpenses+=totalAmount;
            }
            indirectExpensesAndAmount.put(account.getAccountDescription(),totalAmount);
        }
        indirectExpensesAndAmount.put("Total Indirect Expenses",totalIndirectExpenses);
        return indirectExpensesAndAmount;
    }

}
