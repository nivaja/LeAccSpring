package com.lemon.leacc.leacc1.Auth;

import com.lemon.leacc.leacc1.Auth.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepo extends JpaRepository<Company,Integer> {
}
