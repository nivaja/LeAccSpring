package com.lemon.leacc.leacc1.ViewController;

import com.lemon.leacc.leacc1.Auth.SessionService;
import com.lemon.leacc.leacc1.BussinessLogic.GeneralLedger;
import com.lemon.leacc.leacc1.Model.Account;
import com.lemon.leacc.leacc1.RestRepo.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CashBookController {
    @Autowired
    AccountRepo accountRepo;

    @Autowired
    GeneralLedger generalLedger;
    @Autowired
    SessionService sessionService;
    @RequestMapping("/reports/cashBook")
    public String cashBook(Model model){
        Account cash = accountRepo.findByFiscalAccountAndAccountDescription(
                sessionService.getCurrentUserSession().getFiscalAccount(),
                "Cash");

        model.addAttribute("legders",generalLedger.generateLedgerReport(cash));
        return "cash_book";
    }
}
