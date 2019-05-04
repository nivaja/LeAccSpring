package com.lemon.leacc.leacc1.RestRepo;

import com.lemon.leacc.leacc1.Model.FinishedGoodEntry;
import com.lemon.leacc.leacc1.Model.FinishedGoodEntryProducts;
import com.lemon.leacc.leacc1.Model.FiscalAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FinishedGoodEntryRepo extends JpaRepository<FinishedGoodEntry,Integer>{
    List<FinishedGoodEntry> findByFiscalAccount(FiscalAccount fiscalAccount);
}
