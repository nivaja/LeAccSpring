package com.lemon.leacc.leacc1.BussinessLogic;

import com.lemon.leacc.leacc1.BussinessLogic.BusinessModel.StockLegderModel;
import com.lemon.leacc.leacc1.Model.Product;
import com.lemon.leacc.leacc1.Model.PurchaseProduct;
import com.lemon.leacc.leacc1.Model.SalesProduct;
import com.lemon.leacc.leacc1.RestRepo.*;
import lombok.Getter;
import lombok.Setter;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Component
public class StockLedger {
    @Autowired
    SalesProductRepo salesProductRepo;

    @Autowired
    PurchaseProductRepo purchaseProductRepo;



    public List<StockLegderModel> generateStockLedgerByProduct(Product product){
        List<SalesProduct> fromSales = salesProductRepo.findByProduct(product);
        List<PurchaseProduct> fromPurchase = purchaseProductRepo.findByProduct(product);



        List<StockLegderModel> stockLegderModels = new ArrayList<StockLegderModel>();
        fromPurchase.forEach(item -> {
                StockLegderModel stockLegderModel = new StockLegderModel();
                stockLegderModel.setDate(item.getPurchase().getDate());
                stockLegderModel.setReceivedQuantity(item.getQuantity());
                stockLegderModel.setParticular("FROM PURCHASE" +"[" +item.getPurchase().getBillNo()+"] "+item.getPurchase().getPurchaseDescription());
                stockLegderModels.add(stockLegderModel);
            }
        );



        fromSales.forEach(item->{
            StockLegderModel stockLegderModel = new StockLegderModel();
            stockLegderModel.setDate(item.getSales().getDate());
            stockLegderModel.setIssuedQuantity(item.getQuantity());
            stockLegderModel.setParticular("FROM Sales" +" BILL NO:[" +item.getSales().getBillNo()+"] \n"+ item.getSales().getSalesDescription());
            stockLegderModels.add(stockLegderModel);
        });
       stockLegderModels.sort(Comparator.comparing(StockLegderModel::getDate));
        for (int i = 0; i < stockLegderModels.size(); i++) {
            try {
                var slmThis = stockLegderModels.get(i);
                var slmPrev = (i>=1)? stockLegderModels.get(i-1):null;

                if (slmThis.getReceivedQuantity()==0){
                    slmThis.setBalance((i==0)? slmThis.getReceivedQuantity()-slmThis.getIssuedQuantity():slmPrev.getBalance()-slmThis.getIssuedQuantity());

                }else if (slmThis.getIssuedQuantity()==0){
                    slmThis.setBalance((i == 0) ? slmThis.getReceivedQuantity() : slmPrev.getBalance() + slmThis.getReceivedQuantity());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        stockLegderModels.forEach(x->{
            System.out.println(x.getBalance());
        });
        return stockLegderModels;
    }
}
