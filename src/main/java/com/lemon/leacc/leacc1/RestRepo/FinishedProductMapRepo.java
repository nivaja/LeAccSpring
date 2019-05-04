package com.lemon.leacc.leacc1.RestRepo;

import com.lemon.leacc.leacc1.Model.FinishedProductMap;
import com.lemon.leacc.leacc1.Model.FiscalAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FinishedProductMapRepo extends JpaRepository<FinishedProductMap,Integer>{
    List<FinishedProductMap> findByFiscalAccount(FiscalAccount fiscalAccount);
}
