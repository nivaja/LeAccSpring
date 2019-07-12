package com.lemon.leacc.leacc1.BussinessLogic;

import com.lemon.leacc.leacc1.Auth.SessionService;
import com.lemon.leacc.leacc1.Model.FiscalAccount;
import com.lemon.leacc.leacc1.Model.Payment;
import com.lemon.leacc.leacc1.Model.PaymentAccount;
import com.lemon.leacc.leacc1.Model.RecieptAccount;
import com.lemon.leacc.leacc1.RestRepo.PaymentAccountRepo;
import com.lemon.leacc.leacc1.RestRepo.VoucherRecieptAccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Component
public class MonthlyIncome {
    @Autowired
    SessionService sessionService;

    @Autowired
    EntityManager entityManager;
    @Autowired
    PaymentAccountRepo paymentAccountRepo;
    @Autowired
    VoucherRecieptAccountRepo recieptAccountRepo;

    public Map<String,Object> getMonthlyIncome(){
        int fiscalAccountId = sessionService.getCurrentUserSession().getFiscalAccount().getFisacalAccountId();
//        List<Object> net  = new ArrayList<>();
//        List<Object> income = new ArrayList<>();
//        List<Object> expenses = new ArrayList<>();
        Map<String,Object> data = new HashMap<>();
        List<Object> months = Arrays.asList("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
        List<Object> incomeValues = Arrays.asList(0,0,0,0,0,0,0,0,0,0,0,0);
        List<Object> expensesValues = Arrays.asList(0,0,0,0,0,0,0,0,0,0,0,0);


        List<Object[]> income = (List<Object[]>)entityManager.createNativeQuery("select monthname(p.date),sum(pa.amount) from payment p , payment_account pa where pa.payment_id=p.payment_id and p.fiscal_account_id = "+fiscalAccountId+" group by monthname(p.date)").getResultList();
        List<Object[]> expenses = (List<Object[]>)entityManager.createNativeQuery("select monthname(r.date),sum(ra.amount) from reciept r , reciept_account ra where ra.reciept_id=r.reciept_id and r.fiscal_account_id = "+fiscalAccountId+" group by monthname(r.date)").getResultList();
List<Object> net = new ArrayList<>();

        for (Object[] d:income){
            System.out.println(d[0]);
            for(int i = 0; i<=months.size()-1;i++){
                for(int j =0; j<=income.size()-1;j++){
                    if(months.get(i).equals(d[0].toString())){
                        incomeValues.set(i,d[1]);
                    }
                }
            }
        }

        for (Object[] d:expenses){
            System.out.println(d[0]);
            for(int i = 0; i<=months.size()-1;i++){
                for(int j =0; j<=expenses.size()-1;j++){
                    if(months.get(i).equals(d[0].toString())){
                        expensesValues.set(i,d[1]);
                    }
                }
            }
        }

        for(int i =0;i<=incomeValues.size()-1;i++){
            net.add(Double.parseDouble(incomeValues.get(i).toString())-Double.parseDouble(expensesValues.get(i).toString()));
        }

data.put("months",months);
        data.put("income",incomeValues);
        data.put("expenses",expensesValues);
        data.put("net",net);


        expensesValues.forEach(System.out::println);
        incomeValues.forEach(System.out::println);
        months.forEach(System.out::println);
        net.forEach(System.out::println);

        return  data;

    }
}
