package com.lemon.leacc.leacc1.RestRepo;

import com.lemon.leacc.leacc1.Model.Sales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalesRepo extends JpaRepository<Sales,Integer> {
}
