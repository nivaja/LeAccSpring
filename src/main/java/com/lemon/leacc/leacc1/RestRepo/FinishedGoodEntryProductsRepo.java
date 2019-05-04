package com.lemon.leacc.leacc1.RestRepo;

import com.lemon.leacc.leacc1.Model.FinishedGoodEntryProducts;
import com.lemon.leacc.leacc1.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FinishedGoodEntryProductsRepo extends JpaRepository<FinishedGoodEntryProducts,Integer>{
    List<FinishedGoodEntryProducts> findByProduct(Product product);
}
