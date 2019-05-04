package com.lemon.leacc.leacc1.RestRepo;

import com.lemon.leacc.leacc1.Model.FiscalAccount;
import com.lemon.leacc.leacc1.Model.Reciept;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoucherRecieptRepo extends JpaRepository<Reciept,Integer>
{
    List<Reciept> findByFiscalAccount(FiscalAccount fiscalAccount);
}
