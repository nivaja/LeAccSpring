package com.lemon.leacc.leacc1.service;

import com.lemon.leacc.leacc1.Auth.SessionService;
import com.lemon.leacc.leacc1.Model.Sales;
import com.lemon.leacc.leacc1.Model.SalesAgent;
import com.lemon.leacc.leacc1.Model.SalesProduct;
import com.lemon.leacc.leacc1.RestRepo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class SalesService {
    @Autowired
    SalesRepo salesRepo;
    @Autowired
    SalesAgentRepo salesAgentRepo;
    @Autowired
    CustomerRepo customerRepo;
    @Autowired
    VehicleRepo vehicleRepo;
    @Autowired
    ProductRepo productRepo;


    @Autowired
    SessionService sessionService;

    public void save(@RequestBody Map<String, Object> json) throws ParseException { ;
            Sales sales = new Sales();
            List<SalesProduct> salesProducts = new ArrayList<>();

            Map<String, String> salesJson = (Map<String, String>) json.get("sales");
            List<Map<String, String>> salesProductJson = (List<Map<String, String>>) json.get("sales_product");

            System.out.println(salesJson);
            System.out.println(salesProductJson);

            sales.setBillNo(salesJson.get("billNo"));
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH);

            sales.setDate(formatter.parse(salesJson.get("date")));
            sales.setCustomer(customerRepo.getOne(Integer.parseInt(salesJson.get("customer"))));
            sales.setSalesDescription(salesJson.get("description"));
            sales.setSalesAgent(salesAgentRepo.getOne(Integer.parseInt(salesJson.get("salesAgent"))));


            try{
                sales.setStartKm(Double.parseDouble(salesJson.get("startKm")));
                sales.setEndKm(Double.parseDouble(salesJson.get("endKm")));
            }catch (Exception e){

                System.out.println(e.toString());

            }


            sales.setVehicle(vehicleRepo.getOne(Integer.parseInt(salesJson.get("vehicle"))));


            for (Map<String, String> productJson : salesProductJson) {
                SalesProduct salesProduct = new SalesProduct();
                salesProduct.setProduct(productRepo.getOne(Integer.parseInt(productJson.get("Product"))));

                try{
                    salesProduct.setQuantity(Double.parseDouble(productJson.get("Quantity")));

                }catch (Exception e){
                    System.out.println(e.toString());

                }

                try{
                    salesProduct.setAmount(Double.parseDouble(productJson.get("Amount")));

                }catch (Exception e){
                    System.out.println(e.toString());

                }

                try{
                    salesProduct.setRate(Double.parseDouble(productJson.get("Rate")));

                }catch (Exception e){
                    System.out.println(e.toString());

                }

                try{
                    salesProduct.setDiscountAmount(Double.parseDouble(productJson.get("Dis Amt")));

                }catch (Exception e){
                    System.out.println(e.toString());

                }
                try{
                    salesProduct.setDiscountPercent(Double.parseDouble(productJson.get("Dis%")));

                }catch (Exception e){
                    System.out.println(e.toString());

                }
                try{
                    salesProduct.setNetAmount(Double.parseDouble(productJson.get("Net Amount")));

                }catch (Exception e){
                    System.out.println(e.toString());

                }


                salesProduct.setSales(sales);
                salesProducts.add(salesProduct);
            }

            sales.setSalesProducts(salesProducts);
            sales.setFiscalAccount(sessionService.getCurrentUserSession().getFiscalAccount());
            salesRepo.save(sales);


    }
}

