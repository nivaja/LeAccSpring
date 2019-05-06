package com.lemon.leacc.leacc1.RestRepo;

import com.lemon.leacc.leacc1.Model.Account;
import com.lemon.leacc.leacc1.Model.PaymentAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VoucherPaymentAccountRepo extends JpaRepository<PaymentAccount,Integer> {
    List<PaymentAccount> findByAccount(Account account);
}
