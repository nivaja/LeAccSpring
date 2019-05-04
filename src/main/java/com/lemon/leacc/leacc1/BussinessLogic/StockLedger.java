package com.lemon.leacc.leacc1.BussinessLogic;

import com.lemon.leacc.leacc1.BussinessLogic.BusinessModel.StockLegderModel;
import com.lemon.leacc.leacc1.Model.FinishedGoodEntryProducts;
import com.lemon.leacc.leacc1.Model.Product;
import com.lemon.leacc.leacc1.Model.PurchaseProduct;
import com.lemon.leacc.leacc1.Model.SalesProduct;
import com.lemon.leacc.leacc1.RestRepo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StockLedger {
    @Autowired
    SalesProductRepo salesProductRepo;

    @Autowired
    PurchaseProductRepo purchaseProductRepo;

    @Autowired
    FinishedGoodEntryProductsRepo finishedGoodEntryProductsRepo;


    public List<StockLegderModel> generateStockLedgerByProduct(Product product){
        List<SalesProduct> fromSales = salesProductRepo.findByProduct(product);
        List<PurchaseProduct> fromPurchase = purchaseProductRepo.findByProduct(product);
        List<FinishedGoodEntryProducts> fromFinishedGood = finishedGoodEntryProductsRepo.findByProduct(product);



        List<StockLegderModel> stockLegderModels = new ArrayList<StockLegderModel>();
        fromPurchase.forEach(item -> {
                StockLegderModel stockLegderModel = new StockLegderModel();
                stockLegderModel.setDate(item.getPurchase().getDate());
                stockLegderModel.setReceivedQuantity(item.getQuantity());
                stockLegderModel.setParticular("FROM PURCHASE" +"[" +item.getPurchase().getBillNo()+"] "+item.getPurchase().getPurchaseDescription());
                stockLegderModels.add(stockLegderModel);
            }
        );

        fromFinishedGood.forEach(item->{
            StockLegderModel stockLegderModel = new StockLegderModel();
            stockLegderModel.setDate(item.getFinishedGoodEntry().getDate());
            stockLegderModel.setReceivedQuantity(item.getQuantity());
            stockLegderModel.setParticular("FROM Finished Good" +"[" +item.getFinishedGoodEntry().getBillNo()+"] "+item.getFinishedGoodEntry().getDescription());
            stockLegderModels.add(stockLegderModel);
        });

        fromSales.forEach(item->{
            StockLegderModel stockLegderModel = new StockLegderModel();
            stockLegderModel.setDate(item.getSales().getDate());
            stockLegderModel.setIssuedQuantity(item.getQuantity());
            stockLegderModel.setParticular("FROM Sales" +" BILL NO:[" +item.getSales().getBillNo()+"] \n"+ item.getSales().getSalesDescription());
            stockLegderModels.add(stockLegderModel);
        });
       stockLegderModels.sort((model1, model2) -> model1.getDate().compareTo(model2.getDate()));
        return stockLegderModels;
    }
}
