package com.lemon.leacc.leacc1.viewModel;

import com.lemon.leacc.leacc1.Model.Customer;
import com.lemon.leacc.leacc1.Model.Product;
import jdk.nashorn.internal.objects.annotations.Getter;

import javax.persistence.Entity;


public class SalesByCustomerModel {
    private Customer customer;
    private Product product;
    private double amount;

    public SalesByCustomerModel(Customer customer, Product product, double amount) {
        this.customer = customer;
        this.product = product;
        this.amount = amount;
    }

    public SalesByCustomerModel() {
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
