package com.lemon.leacc.leacc1.RestRepo;

import com.lemon.leacc.leacc1.Model.FiscalAccount;
import com.lemon.leacc.leacc1.Model.SubAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubAccountRepo extends JpaRepository<SubAccount,Integer> {
    List<SubAccount> findByAccount_AccountDescription(String accountDescription);
    List<SubAccount> findByFiscalAccount(FiscalAccount fiscalAccount);
}
