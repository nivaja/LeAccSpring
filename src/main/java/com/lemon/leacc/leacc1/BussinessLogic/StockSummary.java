package com.lemon.leacc.leacc1.BussinessLogic;

import com.lemon.leacc.leacc1.Auth.SessionService;
import com.lemon.leacc.leacc1.Model.FiscalAccount;
import com.lemon.leacc.leacc1.Model.Purchase;
import com.lemon.leacc.leacc1.RestRepo.ProductRepo;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class StockSummary {

    @Autowired
    StockLedger stockLedger;
    @Autowired
    ProductRepo productRepo;
    @Autowired
    SessionService sessionService;

    public  Map<String,List<Object>> getStockSummary(){
        Map<String,List<Object>> data =new HashMap<>();
        List<Object> productDes= new ArrayList<>();
        List<Object> quantityList= new ArrayList<>();
        FiscalAccount fiscalAccount = sessionService.getCurrentUserSession().getFiscalAccount();
        productRepo.getByFiscalAccount(fiscalAccount).forEach(product -> {
            var SList =stockLedger.generateStockLedgerByProduct(product);
            productDes.add(product.getProductDescription());
            if (SList.size() > 0) {
                quantityList.add(SList.get(SList.size()-1).getBalance());

            }
        });
        data.put("lable",productDes);
        data.put("quantities",quantityList);
        return data;
    }
}
