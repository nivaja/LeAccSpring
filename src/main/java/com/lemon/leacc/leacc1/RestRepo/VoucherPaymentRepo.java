package com.lemon.leacc.leacc1.RestRepo;

import com.lemon.leacc.leacc1.Model.FiscalAccount;
import com.lemon.leacc.leacc1.Model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoucherPaymentRepo extends JpaRepository<Payment,Integer>{
    List<Payment> findByFiscalAccount(FiscalAccount fiscalAccount);
}
