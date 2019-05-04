package com.lemon.leacc.leacc1.RestRepo;

import com.lemon.leacc.leacc1.Model.Customer;
import com.lemon.leacc.leacc1.Model.FiscalAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepo extends JpaRepository<Customer,Integer> {
    List<Customer> getByFiscalAccount(FiscalAccount fiscalAccount);
}
