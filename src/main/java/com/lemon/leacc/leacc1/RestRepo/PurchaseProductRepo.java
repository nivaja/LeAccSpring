package com.lemon.leacc.leacc1.RestRepo;

import com.lemon.leacc.leacc1.Model.Product;
import com.lemon.leacc.leacc1.Model.PurchaseProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PurchaseProductRepo extends JpaRepository<PurchaseProduct,Integer>{
    List<PurchaseProduct> findByProduct(Product product);
}
