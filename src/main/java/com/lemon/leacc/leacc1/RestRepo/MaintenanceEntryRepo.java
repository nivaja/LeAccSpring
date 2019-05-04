package com.lemon.leacc.leacc1.RestRepo;

import com.lemon.leacc.leacc1.Model.FiscalAccount;
import com.lemon.leacc.leacc1.Model.MaintenanceEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaintenanceEntryRepo extends JpaRepository<MaintenanceEntry,Integer>{

    List<MaintenanceEntry> findByFiscalAccount(FiscalAccount fiscalAccount);
}
