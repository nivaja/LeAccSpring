package com.lemon.leacc.leacc1.BussinessLogic;

import com.lemon.leacc.leacc1.Model.Account;
import com.lemon.leacc.leacc1.Model.PaymentAccount;
import com.lemon.leacc.leacc1.Model.RecieptAccount;
import com.lemon.leacc.leacc1.RestRepo.AccountRepo;
import com.lemon.leacc.leacc1.RestRepo.VoucherPaymentAccountRepo;
import com.lemon.leacc.leacc1.RestRepo.VoucherRecieptAccountRepo;
import com.lemon.leacc.leacc1.viewModel.LedgerModel;
import org.aspectj.weaver.ast.Var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
public class GeneralLedger {

    public GeneralLedger(){}

    @Autowired
    VoucherPaymentAccountRepo voucherPaymentAccountRepo;
    @Autowired
    VoucherRecieptAccountRepo voucherRecieptAccountRepo;

    public List<LedgerModel> generateLedgerReport(Account account){
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
        return ledgerModels;
    }

}
