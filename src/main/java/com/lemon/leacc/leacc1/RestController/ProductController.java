package com.lemon.leacc.leacc1.RestController;

import com.lemon.leacc.leacc1.Auth.SessionService;
import com.lemon.leacc.leacc1.Model.Customer;
import com.lemon.leacc.leacc1.Model.Product;
import com.lemon.leacc.leacc1.RestRepo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    ProductRepo productRepo;

    @Autowired
    SessionService sessionService;

    @GetMapping("/getProducts")
    public List<Product> getAllProducts(){
        return productRepo.getByFiscalAccount(sessionService.getCurrentUserSession().getFiscalAccount());
    }

    @PostMapping("/add")
    public void addProduct(@Valid @RequestBody Product product){
        product.setFiscalAccount(sessionService.getCurrentUserSession().getFiscalAccount());
        productRepo.save(product);
    }
}
