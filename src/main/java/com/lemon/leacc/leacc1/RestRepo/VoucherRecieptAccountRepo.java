package com.lemon.leacc.leacc1.RestRepo;

import com.lemon.leacc.leacc1.Model.Account;
import com.lemon.leacc.leacc1.Model.Reciept;
import com.lemon.leacc.leacc1.Model.RecieptAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VoucherRecieptAccountRepo extends JpaRepository<RecieptAccount,Integer> {
    List<RecieptAccount> findByAccount(Account account);
}
