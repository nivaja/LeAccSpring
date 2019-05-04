package com.lemon.leacc.leacc1.RestRepo;

import com.lemon.leacc.leacc1.Model.FiscalAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FiscalAccountRepo extends JpaRepository<FiscalAccount,Integer> {
}
