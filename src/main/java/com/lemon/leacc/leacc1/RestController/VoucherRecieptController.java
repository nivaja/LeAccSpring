package com.lemon.leacc.leacc1.RestController;

import com.lemon.leacc.leacc1.Auth.SessionService;
import com.lemon.leacc.leacc1.Model.Reciept;
import com.lemon.leacc.leacc1.Model.RecieptAccount;
import com.lemon.leacc.leacc1.RestRepo.AccountRepo;
import com.lemon.leacc.leacc1.RestRepo.SubAccountRepo;
import com.lemon.leacc.leacc1.RestRepo.VoucherRecieptRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/voucherReciept")
public class VoucherRecieptController {
    @Autowired
    SessionService sessionService;

    @Autowired
    VoucherRecieptRepo voucherRecieptRepo;
    @Autowired
    SubAccountRepo subAccountRepo;
    @Autowired
    AccountRepo accountRepo;

    @PostMapping("/add")
    public void add(@RequestBody Reciept reciept){
        reciept.setFiscalAccount(sessionService.getCurrentUserSession().getFiscalAccount());
        reciept.setCashSubAccount(subAccountRepo.getOne(reciept.getCashSubAccount().getSubAccountId()));
        for (RecieptAccount pa:reciept.getRecieptAccount()) {
            pa.setAccount(accountRepo.getOne(pa.getAccount().getAccountId()));
            pa.setReciept(reciept);
            pa.setSubAccount(subAccountRepo.getOne(pa.getSubAccount().getSubAccountId()));
        }
        voucherRecieptRepo.save(reciept);
    }
}
