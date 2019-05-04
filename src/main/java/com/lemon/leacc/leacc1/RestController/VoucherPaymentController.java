package com.lemon.leacc.leacc1.RestController;

import com.lemon.leacc.leacc1.Auth.SessionService;
import com.lemon.leacc.leacc1.Model.Payment;
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


    @RequestMapping("/add")
    public void addPayment(@RequestBody Payment payment){

        payment.setFiscalAccount(sessionService.getCurrentUserSession().getFiscalAccount());
        payment.getPaymentAccount().forEach(enrty -> enrty.setPayment(payment));
        System.out.println(payment);
        voucherPaymentRepo.save(payment);
    }

    @GetMapping("/get/{id}")
    public Payment getById(@PathVariable int id){
        return voucherPaymentRepo.getOne(id);
    }

    @GetMapping("/get/all")
    public List<Payment> getById(){
        return voucherPaymentRepo.findByFiscalAccount(sessionService.getCurrentUserSession().getFiscalAccount());
    }
}
