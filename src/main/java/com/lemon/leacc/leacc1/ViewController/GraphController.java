package com.lemon.leacc.leacc1.ViewController;

import com.lemon.leacc.leacc1.Auth.SessionService;

import com.lemon.leacc.leacc1.Model.Customer;
import com.lemon.leacc.leacc1.Model.FiscalAccount;
import com.lemon.leacc.leacc1.Model.Product;
import com.lemon.leacc.leacc1.Model.SalesProduct;
import com.lemon.leacc.leacc1.RestRepo.CustomerRepo;
import com.lemon.leacc.leacc1.RestRepo.ProductRepo;
import com.lemon.leacc.leacc1.RestRepo.SalesProductRepo;
import com.lemon.leacc.leacc1.RestRepo.SalesRepo;
import com.lemon.leacc.leacc1.viewModel.SalesByCustomerModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.*;

@RestController
@RequestMapping("/api/graph")
public class GraphController {
    @Autowired
    SessionService sessionService;

    @Autowired
    EntityManager entityManager;


    @RequestMapping("/expenses")
    public  Map<String,List<Object>>  getExpenses(){
       Map<String,List<Object>> d=new HashMap<>();
List<Object> label=new ArrayList<>();
List<Object> amount = new ArrayList<>();
List<Object[]> expenses = (List<Object[]>)entityManager.createNativeQuery("Select account_description, sum(amount) as amount from Payment_account pa, Account a, payment p where pa.account_id = a.account_id and p.fiscal_account_id="+sessionService.getCurrentUserSession().getFiscalAccount().getFisacalAccountId()+" group by account_description order by amount limit 5").getResultList();
for(Object[] data: expenses){
    label.add(data[0]);
    amount.add(data[1]);
}
d.put("lable",label);
        d.put("amount",amount);
      return d;
    }


    @RequestMapping("/income")
    public  Map<String,List<Object>>  getIncome(){
        Map<String,List<Object>> d=new HashMap<>();
        List<Object> label=new ArrayList<>();
        List<Object> amount = new ArrayList<>();
        List<Object[]> income = (List<Object[]>)entityManager.createNativeQuery("Select account_description, sum(amount) as amount from reciept_account pa, Account a, Reciept p where pa.account_id = a.account_id and p.fiscal_account_id="+sessionService.getCurrentUserSession().getFiscalAccount().getFisacalAccountId()+" group by account_description order by amount limit 5").getResultList();
        for(Object[] data: income){
            label.add(data[0]);
            amount.add(data[1]);
        }
        d.put("lable",label);
        d.put("amount",amount);
        return d;
    }


    @RequestMapping("/productionVsSales")
    public  Map<String,Object>  productionVsSales(){
        int fiscal_account_id=sessionService.getCurrentUserSession().getFiscalAccount().getFisacalAccountId();
        Map<String,Object> d=new HashMap<>();
        List<Object[]> production  = (List<Object[]>)entityManager.createNativeQuery("select fge.date, sum(fgep.quantity) from finished_good_entry fge, finished_good_entry_products fgep where fge.finished_good_entry_id=fgep.finished_good_entry_id and fge.fiscal_account_fiscal_account_id="+ fiscal_account_id+" group by fge.date order by fge.date").getResultList();
        List<Object[]> sales=  (List<Object[]>)entityManager.createNativeQuery("select s.date,sum(sp.quantity) from sales s, sales_product sp where sp.sales_entry_id=s.sales_id and s.fiscal_account_id="+fiscal_account_id +" group by s.date order by s.date").getResultList();

        Map<String,List<Object>> proMap=new HashMap<>();
        List<Object> date= new ArrayList<>();
        List<Object> proQua=new ArrayList<>();
        for(Object[] data: production){
            date.add(data[0]);
            proQua.add(data[1]);
        }
        proMap.put("production",proQua);

        Map<String,List<Object>> salesMap=new HashMap<>();
        List<Object> date1= new ArrayList<>();
        List<Object> saleQua=new ArrayList<>();
        for(Object[] data: sales){
            date.add(data[0]);
            saleQua.add(data[1]);
        }
        salesMap.put("sales",saleQua);
        for (Object x : date1){
            if (!date.contains(x))
                date.add(x);
        }

        d.put("date",date);
    d.put("production",proQua);
    d.put("sales",saleQua);
    return d;

    }

    @Autowired
    CustomerRepo customerRepo;
    @Autowired
    SalesRepo salesRepo;
    @Autowired
    SalesProductRepo salesProductRepo;
    @Autowired
    ProductRepo productRepo;
    @RequestMapping("/salesByCustomer")
    public  Map<String,List<Object>> salesByCustomer(){
        FiscalAccount fiscalAccount =sessionService.getCurrentUserSession().getFiscalAccount();
        Map<String,List<Object>> data=new HashMap<>();
        List<SalesByCustomerModel> sbcList = new ArrayList<>();
        List<Object> customers = new ArrayList<>();
        List<Object> products =new ArrayList<>();
                customerRepo.getByFiscalAccount(fiscalAccount).forEach(x->customers.add(x.getName()));
        List<Object> amounts = new ArrayList<>();

//        customerRepo.getByFiscalAccount(fiscalAccount).forEach(cus->{
//            customers.add(cus.getName());
//            productRepo.getByFiscalAccount(fiscalAccount).forEach(product -> {
//                final double[] amount = {0};
//                salesProductRepo.findBySales_Customer(cus).stream().
//                        filter(salesProduct -> salesProduct.getProduct()== product).forEach(x->{
//                            amount[0] += x.getAmount();
//                });
//                amounts.add(amount[0]);
//                SalesByCustomerModel sbcModel= new SalesByCustomerModel(cus,product, amount[0]);
//
//                sbcList.add(sbcModel);
//                });
//
//            });


        productRepo.getByFiscalAccount(fiscalAccount).forEach(product->{
            products.add(product.getProductDescription());
            customerRepo.getByFiscalAccount(fiscalAccount).forEach(customer -> {
                final double[] amount = {0};
                salesProductRepo.findByProduct(product).stream().
                        filter(salesProduct -> salesProduct.getSales().getCustomer()== customer).forEach(x->{
                    amount[0] += x.getAmount();
                });
                amounts.add(amount[0]);
                SalesByCustomerModel sbcModel= new SalesByCustomerModel(customer,product, amount[0]);

                sbcList.add(sbcModel);
            });

        });

data.put("customers",customers);
data.put("products",(List<Object>) products);
data.put("amounts",amounts);

        sbcList.forEach(x->{
            System.out.println(x.getCustomer().getName()+", "+x.getProduct().getProductDescription()+", "+x.getAmount());
        });
return data;
    }
}

