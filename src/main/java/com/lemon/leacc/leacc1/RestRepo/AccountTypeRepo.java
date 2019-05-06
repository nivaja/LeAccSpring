package com.lemon.leacc.leacc1.RestRepo;

import com.lemon.leacc.leacc1.Model.Account;
import com.lemon.leacc.leacc1.Model.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountTypeRepo extends JpaRepository<AccountType,Integer> {
    AccountType findByAccountTypeDescription(String desc);

}
