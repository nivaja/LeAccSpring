package com.lemon.leacc.leacc1.RestController;

import com.lemon.leacc.leacc1.Auth.SessionService;
import com.lemon.leacc.leacc1.Model.Payment;
import com.lemon.leacc.leacc1.Model.PaymentAccount;
import com.lemon.leacc.leacc1.RestRepo.AccountRepo;
import com.lemon.leacc.leacc1.RestRepo.SubAccountRepo;
import com.lemon.leacc.leacc1.RestRepo.VoucherPaymentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/voucherPayment")
public class VoucherPaymentController {
    @Autowired
    SessionService sessionService;
    @Autowired
    VoucherPaymentRepo voucherPaymentRepo;
@Autowired
    SubAccountRepo subAccountRepo;
@Autowired
    AccountRepo accountRepo;

    @RequestMapping("/add")
    public void addPayment(@RequestBody Payment payment){

        payment.setFiscalAccount(sessionService.getCurrentUserSession().getFiscalAccount());
        payment.setCashSubAccount(subAccountRepo.getOne(payment.getCashSubAccount().getSubAccountId()));
       // payment.getPaymentAccount().forEach(enrty -> enrty.setPayment(payment));
        for (PaymentAccount pa:payment.getPaymentAccount()) {
            pa.setAccount(accountRepo.getOne(pa.getAccount().getAccountId()));
            pa.setPayment(payment);
            pa.setSubAccount(subAccountRepo.getOne(pa.getSubAccount().getSubAccountId()));
        }
        System.out.println(payment);
        voucherPaymentRepo.save(payment);
    }

    @GetMapping("/get/{id}")
    public Payment getById(@PathVariable int id){
        return voucherPaymentRepo.getOne(id);
    }

    @GetMapping("/get/all")
    public List<Payment> getAll(){
        return voucherPaymentRepo.findByFiscalAccount(sessionService.getCurrentUserSession().getFiscalAccount());
    }
}
