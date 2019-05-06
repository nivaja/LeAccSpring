package com.lemon.leacc.leacc1.RestRepo;

import com.lemon.leacc.leacc1.Model.Account;
import com.lemon.leacc.leacc1.Model.FiscalAccount;
import com.lemon.leacc.leacc1.Model.PaymentAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentAccountRepo extends JpaRepository<PaymentAccount,Integer>{
    List<PaymentAccount> findByAccount(Account account);
    List<PaymentAccount> findByAccount_FiscalAccount(FiscalAccount fiscalAccount);
}
