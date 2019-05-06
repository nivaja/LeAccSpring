package com.lemon.leacc.leacc1.service;

import com.lemon.leacc.leacc1.Model.FiscalAccount;
import com.lemon.leacc.leacc1.Model.PaymentAccount;
import com.lemon.leacc.leacc1.RestRepo.PaymentAccountRepo;
import com.lemon.leacc.leacc1.RestRepo.VoucherPaymentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public class PaymentService {
    @Autowired
    PaymentAccountRepo paymentAccountRepo;

    public List<PaymentAccount> findByFiscalAccount(FiscalAccount fiscalAccount){
        return paymentAccountRepo.findByAccount_FiscalAccount(fiscalAccount);
    }
}
