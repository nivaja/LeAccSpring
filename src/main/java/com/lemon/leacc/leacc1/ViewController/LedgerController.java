package com.lemon.leacc.leacc1.ViewController;

import com.lemon.leacc.leacc1.Auth.SessionService;
import com.lemon.leacc.leacc1.BussinessLogic.GeneralLedger;
import com.lemon.leacc.leacc1.Model.Account;
import com.lemon.leacc.leacc1.Model.PaymentAccount;
import com.lemon.leacc.leacc1.Model.RecieptAccount;
import com.lemon.leacc.leacc1.RestRepo.AccountRepo;
import com.lemon.leacc.leacc1.RestRepo.VoucherPaymentAccountRepo;
import com.lemon.leacc.leacc1.RestRepo.VoucherRecieptAccountRepo;
import com.lemon.leacc.leacc1.viewModel.LedgerModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class LedgerController {
    @Autowired
    AccountRepo accountRepo;

    @Autowired
    GeneralLedger generalLedger;
    @Autowired
    SessionService sessionService;


    @RequestMapping("reports/ledger")
    public String getLedger(@RequestParam(value = "account", required = false) Integer id, Model model ){
        if(id==null){
            model.addAttribute("accounts",accountRepo.findByFiscalAccount(sessionService.getCurrentUserSession().getFiscalAccount()));
            return "ledger";
        }
            Account account=accountRepo.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("Invalid Account Id:" + id));

        List<LedgerModel> ledgerModels=generalLedger.generateLedgerReport(account);
        model.addAttribute("ledgers",ledgerModels);
        model.addAttribute("accounts",accountRepo.findByFiscalAccount(sessionService.getCurrentUserSession().getFiscalAccount()));
        return "ledger";
    }
}
