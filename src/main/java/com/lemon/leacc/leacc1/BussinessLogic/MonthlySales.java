package com.lemon.leacc.leacc1.BussinessLogic;

import com.lemon.leacc.leacc1.Auth.SessionService;
import com.lemon.leacc.leacc1.RestRepo.SalesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.*;

@Component
public class MonthlySales {
    @Autowired
    SessionService sessionService;
    @Autowired
    SalesRepo salesRepo;
    @Autowired
    EntityManager entityManager;

    public Map<String,Object> getMonthlySales(){
        var fiscalAccountId = sessionService.getCurrentUserSession().getFiscalAccount().getFisacalAccountId();
        Map<String,Object> json= new HashMap<>();
        List<Object[]> data = (List<Object[]>)entityManager.createNativeQuery("select MONTHNAME(s.date),sum(sp.net_amount) from sales s, sales_product sp where s.sales_id=sp.sales_entry_id and s.fiscal_account_id= " + fiscalAccountId+" group by MONTHNAME(s.date);").getResultList();


        List<Object> months = Arrays.asList("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
        List<Object> values = Arrays.asList(0,0,0,0,0,0,0,0,0,0,0,0);
        for (Object[] d:data){
            System.out.println(d[0]);
            for(int i = 0; i<=months.size()-1;i++){
                for(int j =0; j<=data.size()-1;j++){
                    if(months.get(i).equals(d[0].toString())){
                        values.set(i,d[1]);
                    }
                }
            }
        }
        json.put("lables",months);
        json.put("values",values);
        months.forEach(x->{
            System.out.println((String) x);
        });
        values.forEach(x->{
            System.out.println(x);
        });

        return json;
    }
}
