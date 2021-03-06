package com.lemon.leacc.leacc1.RestRepo;

import com.lemon.leacc.leacc1.Model.FiscalAccount;
import com.lemon.leacc.leacc1.Model.Godown;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GodownRepo extends JpaRepository<Godown,Integer> {
        List<Godown> getByFiscalAccount(FiscalAccount fiscalAccount);
}
