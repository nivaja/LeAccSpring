package com.lemon.leacc.leacc1.ViewController;

import com.lemon.leacc.leacc1.Auth.SessionService;
import com.lemon.leacc.leacc1.BussinessLogic.StockLedger;
import com.lemon.leacc.leacc1.Model.Account;
import com.lemon.leacc.leacc1.Model.PaymentAccount;
import com.lemon.leacc.leacc1.Model.Product;
import com.lemon.leacc.leacc1.Model.RecieptAccount;
import com.lemon.leacc.leacc1.RestRepo.ProductRepo;
import com.lemon.leacc.leacc1.viewModel.LedgerModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class stockLedgerController {
    @Autowired
    SessionService sessionService;
    @Autowired
    ProductRepo productRepo;
    @Autowired
    StockLedger stockLedger;
    @RequestMapping("reports/stockLedger")
    public String getLedger(@RequestParam(value = "product", required = false) Integer id, Model model ){
        if(id==null){
            model.addAttribute("products",productRepo.getByFiscalAccount(sessionService.getCurrentUserSession().getFiscalAccount()));
            return "stock_ledger_index";
        }
        Product product=productRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Product Id:" + id));


        model.addAttribute("products",productRepo.getByFiscalAccount(sessionService.getCurrentUserSession().getFiscalAccount()));
        model.addAttribute("stocks",stockLedger.generateStockLedgerByProduct(product));
        return "stock_ledger_index";
    }
}
