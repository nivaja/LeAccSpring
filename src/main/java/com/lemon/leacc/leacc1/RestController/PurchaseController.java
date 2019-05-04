package com.lemon.leacc.leacc1.RestController;

import com.lemon.leacc.leacc1.Auth.SessionService;
import com.lemon.leacc.leacc1.Model.Purchase;
import com.lemon.leacc.leacc1.RestRepo.PurchaseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/purchase/")
@RestController
public class PurchaseController {

    @Autowired
    SessionService sessionService;
    @Autowired
    PurchaseRepo purchaseRepo;


    @RequestMapping("/add")
    public void addPurchase(@RequestBody Purchase purchase){
        purchase.setFiscalAccount(sessionService.getCurrentUserSession().getFiscalAccount());
        purchase.getPurchaseProducts().forEach(enrty -> enrty.setPurchase(purchase));
        System.out.println(purchase);
         purchaseRepo.save(purchase);

    }

    @GetMapping("/getAll")
    public List<Purchase> getAll(){
        return purchaseRepo.findAll();
    }
}
