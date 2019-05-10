package com.lemon.leacc.leacc1.ViewController;

import com.lemon.leacc.leacc1.Auth.SessionService;
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
    VoucherPaymentAccountRepo voucherPaymentAccountRepo;
    @Autowired
    VoucherRecieptAccountRepo voucherRecieptAccountRepo;

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

            List<LedgerModel> ledgerModels =new ArrayList<>();
        List<PaymentAccount> pa = voucherPaymentAccountRepo.findByAccount(account);
        pa.forEach(x->{
            LedgerModel lm = new LedgerModel();
            lm.setDate(x.getPayment().getDate());
            lm.setParticular(x.getRemarks());
            lm.setPayment(x.getAmount());
            ledgerModels.add(lm);
        });

        List<RecieptAccount> ra = voucherRecieptAccountRepo.findByAccount(account);
        ra.forEach(x->{
            LedgerModel lm = new LedgerModel();
            lm.setDate(x.getReciept().getDate());
            lm.setParticular(x.getRemarks());
            lm.setReciept(x.getAmount());
            ledgerModels.add(lm);
        });
        ledgerModels.sort((model1, model2) -> model1.getDate().compareTo(model2.getDate()));
        model.addAttribute("ledgers",ledgerModels);
        model.addAttribute("accounts",accountRepo.findByFiscalAccount(sessionService.getCurrentUserSession().getFiscalAccount()));
        return "ledger";
    }
}
