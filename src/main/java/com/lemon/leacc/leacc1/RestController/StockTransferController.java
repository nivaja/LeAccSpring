package com.lemon.leacc.leacc1.RestController;

import com.lemon.leacc.leacc1.Auth.SessionService;
import com.lemon.leacc.leacc1.Model.StockTransfer;
import com.lemon.leacc.leacc1.RestRepo.StockTransferRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("api/inventoryTransfer")
public class StockTransferController {
    @Autowired
    SessionService sessionService;
    @Autowired
    StockTransferRepo stockTransferRepo;


    @RequestMapping("/add")
    public void addStockTransfer(@RequestBody StockTransfer stockTransfer){

        stockTransfer.setFiscalAccount(sessionService.getCurrentUserSession().getFiscalAccount());
        stockTransfer.getInventoryTransferProducts().forEach(enrty -> enrty.setStockTransfer(stockTransfer));
        //System.out.println(stockTransfer);
        stockTransferRepo.save(stockTransfer);
    }

    @GetMapping("/get/{id}")
    public StockTransfer getById(@PathVariable int id){
        return stockTransferRepo.getOne(id);
    }

    @GetMapping("/get/all")
    public List<StockTransfer> getById(){
        return stockTransferRepo.findByFiscalAccount(sessionService.getCurrentUserSession().getFiscalAccount());
    }
}
