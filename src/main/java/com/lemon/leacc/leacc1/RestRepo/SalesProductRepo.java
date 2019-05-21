package com.lemon.leacc.leacc1.RestRepo;

import com.lemon.leacc.leacc1.Model.Customer;
import com.lemon.leacc.leacc1.Model.Product;
import com.lemon.leacc.leacc1.Model.SalesProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalesProductRepo extends JpaRepository<SalesProduct,Integer>{
    List<SalesProduct> findByProduct(Product product);
    List<SalesProduct> findBySales_Customer(Customer customer);

}
