package com.lemon.leacc.leacc1.RestController;


import com.lemon.leacc.leacc1.Model.AccountType;
import com.lemon.leacc.leacc1.RestRepo.AccountGroupRepo;
import com.lemon.leacc.leacc1.RestRepo.AccountTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api/accountType")
@RestController
public class AccountTypeController {
    @Autowired
    private AccountTypeRepo accountTypeRepo;

    @Autowired
    AccountGroupRepo accountGroupRepo;

    @GetMapping("/all")
    public List<AccountType> allAccountType(){
        return accountTypeRepo.findAll();
    }

    @GetMapping("{id}")
    public Optional<AccountType> getAccountType(@PathVariable int id){
        Optional<AccountType> AccountType = accountTypeRepo.findById(id);
        if (!AccountType.isPresent()){
            throw  new NullPointerException("AccountType Not Found");
        }
        System.out.println(accountTypeRepo.getOne(id).getAccountGroup());
        return AccountType;
    }

    @PostMapping("/addAccountType")
    public void addAccountType(@RequestBody AccountType AccountType){
        accountTypeRepo.save(AccountType);
    }

    @PutMapping("/put/{id}")
    @ResponseStatus(HttpStatus.RESET_CONTENT)
    public void putAccountType(@PathVariable int id, @RequestBody AccountType putAccountType){
        Optional<AccountType> accountType = accountTypeRepo.findById(id);
        if (!accountType.isPresent()){
            throw new NullPointerException("AccountType Not Found");
        }
        putAccountType.setAccountTypeId(id);
        accountTypeRepo.save(putAccountType);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.RESET_CONTENT)
    public void deleteAccountType(@PathVariable int id){
        Optional<AccountType> accountType = accountTypeRepo.findById(id);
        if (!accountType.isPresent()){
            throw new NullPointerException("AccountType Not Found");
        }
        accountTypeRepo.deleteById(id);
    }
}
