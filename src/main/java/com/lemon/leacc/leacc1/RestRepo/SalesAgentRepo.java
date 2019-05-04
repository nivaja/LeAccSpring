package com.lemon.leacc.leacc1.RestRepo;

import com.lemon.leacc.leacc1.Model.FiscalAccount;
import com.lemon.leacc.leacc1.Model.SalesAgent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalesAgentRepo extends JpaRepository<SalesAgent,Integer>{
    List<SalesAgent> getByFiscalAccount(FiscalAccount fiscalAccount);
}
