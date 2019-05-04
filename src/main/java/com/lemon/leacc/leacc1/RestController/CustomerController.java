package com.lemon.leacc.leacc1.RestController;

import com.lemon.leacc.leacc1.Auth.SessionService;
import com.lemon.leacc.leacc1.Model.Customer;
import com.lemon.leacc.leacc1.Model.FiscalAccount;
import com.lemon.leacc.leacc1.RestRepo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    SessionService sessionService;

    @PostMapping("/add")
    public void addCustomer(@Valid @RequestBody Customer customer){
        customer.setFiscalAccount(sessionService.getCurrentUserSession().getFiscalAccount());
        customerRepo.save(customer);
    }

    @GetMapping("getAll")
    public List<Customer> getAllCustomer(){
        return customerRepo.getByFiscalAccount(sessionService.getCurrentUserSession().getFiscalAccount());
    }




}
