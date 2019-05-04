package com.lemon.leacc.leacc1.viewModel;

import com.lemon.leacc.leacc1.Model.Customer;
import com.lemon.leacc.leacc1.Model.Sales;
import com.lemon.leacc.leacc1.Model.SalesProduct;
import com.lemon.leacc.leacc1.RestRepo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

public class CustomerView {
    private double averageSales;
    private double averageIncome;
    private double totalCustomer;
    private double highestIncome;
    private double highSales;

    private  Customer customer;

    private List<Sales> sales;


    public CustomerView(Customer customer) {
        this.customer = customer;

    }





    public Map<String,Double> headerCardData() {
        Map<String,Double> data=new HashMap<String,Double>();
        double totalSalesAmount=0;
        double avgIncome=0;
        double salesCount=0;
        for (Sales s:customer.getSales()) {
            for (SalesProduct sp: s.getSalesProducts()) {
                totalSalesAmount+=sp.getAmount();
                salesCount+=1;
            }
        }
        data.put("totalSalesAmount",totalSalesAmount);
        data.put("avgSalesAmount", (double) Math.round(totalSalesAmount/salesCount));
        return data;
    }

    public double getAverageSales() {
        return averageSales;
    }

    public void setAverageSales(double averageSales) {
        this.averageSales = averageSales;
    }



    public void setAverageIncome(double averageIncome) {
        this.averageIncome = averageIncome;
    }

    public double getTotalCustomer() {
        return totalCustomer;
    }

    public void setTotalCustomer(double totalCustomer) {
        this.totalCustomer = totalCustomer;
    }

    public double getHighestIncome() {
        return highestIncome;
    }



    public double getHighSales() {
        return highSales;
    }

    public void setHighSales(double highSales) {
        this.highSales = highSales;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Sales> getSales() {
        return this.customer.getSales();
    }

    public void setSales(List<Sales> sales) {

        this.sales = sales;
    }


}
