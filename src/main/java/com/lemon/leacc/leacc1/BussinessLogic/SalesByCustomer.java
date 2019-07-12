package com.lemon.leacc.leacc1.BussinessLogic;

import com.lemon.leacc.leacc1.Auth.SessionService;
import com.lemon.leacc.leacc1.RestRepo.SalesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class SalesByCustomer {
    @Autowired
    SessionService sessionService;
    @Autowired
    SalesRepo salesRepo;
    @Autowired
    EntityManager entityManager;

    public void getSalesByCustomer(){
        int fiscalAccountId = sessionService.getCurrentUserSession().getFiscalAccount().getFisacalAccountId();
        Map<String,Object> json= new HashMap<>();
        List<Object[]> data = (List<Object[]>)entityManager.createNativeQuery("select c.name, sum(sp.net_amount), p.product_description from customer c, sales s, sales_product sp, product p\n" +
                "    where c.customer_id = s.customer_id and s.sales_id = sp.sales_entry_id and sp.product_id = p.product_id and s.fiscal_account_id= "+fiscalAccountId +" group by name, product_description;").getResultList();

        for (Object[] d:data){
            System.out.println(d[0]);
            System.out.println(d[1]);
            System.out.println(d[2]);
        }
    }

}
